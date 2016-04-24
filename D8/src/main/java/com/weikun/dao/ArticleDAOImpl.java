package com.weikun.dao;

import java.io.BufferedReader;
import java.io.Reader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.weikun.db.C3P0;
import com.weikun.db.DruidDB;
import com.weikun.vo.Article;
import com.weikun.vo.BBSUser;
import com.weikun.vo.PageBean;

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
					a.setId(rs.getInt("a.id"));
					a.setRootid(rs.getInt("a.rootid"));
					a.setTitle(rs.getString("a.title"));
					a.setUserid(rs.getString("a.userid"));
					//读取CLOB
				//	a.setContent(rs.getString("content"));
					a.setDatetime(rs.getString("a.datetime"));			
					
					
					Reader r=rs.getCharacterStream("a.content");				
					
					BufferedReader br=new BufferedReader(r);
					
					String s="";
					StringBuffer sb=new StringBuffer();
					while(  (s=br.readLine())!=null){
						sb.append(s);
					}
					a.setContent(sb.toString());
					a.setDatetime(rs.getString("datetime"));
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

}
