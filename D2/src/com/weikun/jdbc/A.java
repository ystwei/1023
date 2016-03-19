package com.weikun.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class A {
	public static void main(String[] args) {
		Connection conn=null;		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//1加载驱动到内存 
			Class.forName("org.gjt.mm.mysql.Driver");			
			//2应用驱动进行联接
			conn=DriverManager.getConnection("jdbc:mysql://192.168.1.112/bz?useUnicode=true&characterEncoding=utf-8", 
					"root","root");			
			//3.执行SQL语句
			String sql="select * from products ";
			pstmt=conn.prepareStatement(sql);			
			rs=pstmt.executeQuery();
			//4遍历结果集			
			while(rs.next()){
				System.out.println(rs.getString("prod_id")+"--"+rs.getString("prod_price"));
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				//5关闭
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
