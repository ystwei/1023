package com.weikun.dao;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.weikun.db.C3P0;
import com.weikun.db.DruidDB;
import com.weikun.vo.Article;
import com.weikun.vo.BBSUser;
import com.weikun.vo.PageBean;
import com.weikun.vo.ReplyArticle;

public class ArticleDAOImpl implements IArticleDAO {
	private static Connection conn=null;
	
	public ArticleDAOImpl(){
		conn=C3P0.getConnection();
	}
	@Override
	public PageBean queryArticles(int curPage,int userid) {
		// TODO Auto-generated method stub
		CallableStatement cs=null;
		ResultSet rs=null;
		PageBean pb= new PageBean();
		List<Article> list=new ArrayList<Article>();
		try {
			cs=conn.prepareCall("{call q1(?,?,?,?,?)}");
			
			cs.setInt(1, curPage);
			cs.setInt(2, userid);
			
			cs.registerOutParameter(3, java.sql.Types.INTEGER);//最大页数
			cs.registerOutParameter(4, java.sql.Types.INTEGER);//最大行数
			cs.registerOutParameter(5, java.sql.Types.INTEGER);//每页行数
			
			
			
			boolean has=cs.execute();
			
			while(has){
				
				pb.setMaxPage(cs.getInt(3));//mysql的返回值
				pb.setMaxRows(cs.getInt(4));
				pb.setRowsPerPage(cs.getInt(5));
				
				rs=cs.getResultSet();
				
				while(rs.next()){
					Article a=new Article();
					BBSUser user=new BBSUser();
					
					
					a.setId(rs.getInt("a.id"));
					a.setRootid(rs.getInt("a.rootid"));
					a.setTitle(rs.getString("a.title"));
					a.setUserid(rs.getString("a.userid"));
					//读取CLOB
				//	a.setContent(rs.getString("content"));
					a.setDatetime(rs.getString("a.datetime"));			
					
					user.setId(rs.getInt("u.id"));
					
					Reader r=rs.getCharacterStream("a.content");				
					
					BufferedReader br=new BufferedReader(r);
					
					String s="";
					StringBuffer sb=new StringBuffer();
					while(  (s=br.readLine())!=null){
						sb.append(s);
					}
					a.setContent(sb.toString());
					a.setDatetime(rs.getString("datetime"));
					
					a.setUser(user);
					
					list.add(a);
					
				}
				pb.setData(list);//当前页数据
				
				has=cs.getMoreResults();
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		pb.setCurPage(curPage);
		
		return pb;
	}
	@Override
	public PageBean deleteArticle(int id) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		String sql="delete from article where id=?";
		try {			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			return pstmt.executeUpdate()>0?this.queryArticles(1,999):null;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public PageBean addArticle(Article a) {
		// TODO Auto-generated method stub
		
		PreparedStatement pstmt=null;
		String sql="insert into article(title,content,rootid,userid,datetime) "
				+ "values(?,?,?,?,now())";
		try {			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,a.getTitle() );
			
			Reader reader=new  StringReader(a.getContent());
			pstmt.setCharacterStream(2, reader, a.getContent().length()); //clob
			pstmt.setInt(3,a.getRootid());//暂时是0 0代表主贴
			pstmt.setInt(4,a.getUser().getId() );		
			return pstmt.executeUpdate()>0?this.queryArticles(1,a.getUser().getId()):null;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public ReplyArticle queryCTById(int id) {
		// TODO Auto-generated method stub
		CallableStatement cs=null;
		ReplyArticle ra=null;
		ResultSet rs=null;
		try {
			cs=conn.prepareCall("{call q2(?,?,?)}");			
			cs.setInt(1, id);
			cs.registerOutParameter(2, java.sql.Types.INTEGER);
			cs.registerOutParameter(3, java.sql.Types.VARCHAR);
			
			boolean hasnext=cs.execute();			
			while(hasnext){
				ra=new ReplyArticle();
				ra.setZtuid(cs.getInt(2));//发主贴的那个人的id
				ra.setTitle(cs.getString(3));//主帖标题
				
				rs=cs.getResultSet();
				List<Article> list=new ArrayList<Article>();
				//所有从贴遍历
				while(rs.next()){
					
					Article a=new Article();
					
					a.setId(rs.getInt("id"));
					a.setTitle(rs.getString("title"));
					a.setRootid(rs.getInt("rootid"));
					a.setUserid(rs.getString("userid"));
					BufferedReader br=new BufferedReader(rs.getCharacterStream("content"));
					StringBuffer sb=new StringBuffer();
					String s=null;
					while((s=br.readLine())!=null){
						
						sb.append(s);
						
					}
					
					
					a.setContent(sb.toString());//clob
					
					
					br.close();
					
					list.add(a);
					
				}
				ra.setList(list);
				hasnext=cs.getMoreResults();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(cs!=null){
				try {
					cs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return ra;
	}
	@Override
	public ReplyArticle deleteCtById(int id,int rootid) {
		// TODO Auto-generated method stub
		
		
		PreparedStatement pstmt=null;
		String sql="delete from article where id=?  and rootid=?";
		try {			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2, rootid);
			return pstmt.executeUpdate()>0?this.queryCTById(rootid):null;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
