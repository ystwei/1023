package com.weikun.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.weikun.db.DruidDB;
import com.weikun.vo.Article;
import com.weikun.vo.BBSUser;

public class BBSUserDAOImpl implements IBBSUserDAO {
	private static Connection conn;
	public BBSUserDAOImpl(){
		conn=DruidDB.getConnection();
		
	}

	@Override
	public BBSUser login(BBSUser user) {
		// TODO Auto-generated method stub
		BBSUser user1=null;
		String sql="select id,username from bbsuser where username=? and password=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			
			rs=pstmt.executeQuery();
			if(rs.next()){//登录成功
				user1=new BBSUser();
				
				
				user1.setId(rs.getInt("id"));
				user1.setUsername(rs.getString("username"));
			}
			//取Blob pic数据	
			
			
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
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		return user1;
	}

	@Override
	public InputStream readPIC(int id) {
		// TODO Auto-generated method stub
		
		String sql="select pic from bbsuser where id=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		InputStream is=null;
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			rs=pstmt.executeQuery();
			if(rs.next()){//取Blob pic数据	
				is=rs.getBinaryStream("pic");
				
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
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		return is;
	}

	@Override
	public void register(BBSUser user) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		try {
			String sql="insert into bbsuser (username,password,pic) values(?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
		
			
			//留作存储blob
			
			String picpath=user.getPicpath();
			File file=new File(picpath);
			
			FileInputStream fis=new FileInputStream(file);
			
			pstmt.setBinaryStream(3, fis, fis.available());
			
			
			
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	

}
