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
			//1�����������ڴ� 
			Class.forName("org.gjt.mm.mysql.Driver");			
			//2Ӧ��������������
			conn=DriverManager.getConnection("jdbc:mysql://192.168.1.112/bz?useUnicode=true&characterEncoding=utf-8", 
					"root","root");			
			//3.ִ��SQL���
			String sql="select * from products ";
			pstmt=conn.prepareStatement(sql);			
			rs=pstmt.executeQuery();
			//4���������			
			while(rs.next()){
				System.out.println(rs.getString("prod_id")+"--"+rs.getString("prod_price"));
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				//5�ر�
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
