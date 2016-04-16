package com.weikun.dao;

import com.weikun.db.DB;
import com.weikun.vo.Message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class MessageDAOImpl implements IMessageDAO {
	private static Connection conn=DB.getConnection();
	@Override
	public boolean addMessage(Message message) {
		// TODO Auto-generated method stub
		String sql="insert into message (name,email,title,content,date) "
				+ "values(?,?,?,?,now())";
		PreparedStatement pstmt=null;
		boolean flag=false;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, message.getName());
			pstmt.setString(2, message.getEmail());
			pstmt.setString(3, message.getTitle());
			pstmt.setString(4, message.getContent());
			flag=pstmt.executeUpdate()>0?true:false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public List<Message> viewMessage() {
		// TODO Auto-generated method stub
		
		String sql="select * from message order by id desc";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Message> list=new ArrayList<Message>();
		try {
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				Message a=new Message();
				a.setId(rs.getInt("id"));
				a.setName(rs.getString("name"));
				a.setEmail(rs.getString("email"));
				a.setTitle(rs.getString("title"));
				a.setContent(rs.getString("content"));
				a.setDate(rs.getString("date"));
				list.add(a);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
		

	}

	@Override
	public boolean delMessage(int id) {
		// TODO Auto-generated method stub
		String sql="delete from message where id=?";
		PreparedStatement pstmt=null;
		boolean flag=false;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,id);			
			flag=pstmt.executeUpdate()>0?true:false;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

}

