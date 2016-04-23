package com.weikun.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.weikun.db.DruidDB;
import com.weikun.vo.Article;

public class ArticleDAOImpl implements IArticleDAO {
	private static Connection conn=null;
	public ArticleDAOImpl(){
		conn=DruidDB.getConnection();
	}
	@Override
	public List<Article> queryArticles() {
		// TODO Auto-generated method stub
		CallableStatement cs=null;
		ResultSet rs=null;
		List<Article> list=new ArrayList<Article>();
		try {
			cs=conn.prepareCall("{call q1()}");
			
			boolean has=cs.execute();
			
			while(has){
				
				rs=cs.getResultSet();
				while(rs.next()){
					Article a=new Article();
					a.setId(rs.getInt("id"));
					a.setRootid(rs.getInt("rootid"));
					a.setTitle(rs.getString("title"));
					//读取CLOB
				//	a.setContent(rs.getString("content"));
					a.setDatetime(rs.getString("datetime"));
					list.add(a);
					
				}
				
				has=cs.getMoreResults();
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return list;
	}

}
