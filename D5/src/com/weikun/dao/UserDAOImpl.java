package com.weikun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.weikun.db.DB;
import com.weikun.vo.MyUser;

public class UserDAOImpl implements IUserDAO {
	/**
	 *  返回值：true：登录成功 false：登录失败
	 *  user:用来传递用户名 密码的对象
	 * 
	 */
	private Connection conn=DB.getConnection();
	
	
	@Override
	public boolean login(MyUser user) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean flag=false;
		try {
			String sql="select username from myuser where username=? and pwd=? ";
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPwd());
			
			rs=pstmt.executeQuery();
			
			flag=rs.next();
			
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
			//DB.close();
		}		
		return flag;
	}

}
