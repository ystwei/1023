package com.weikun.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





public class A {
	public static void main(String[] args) {
		execFun();
	}
	private static void execPro() {//procedure过程
		
		Connection conn=null;
		CallableStatement cs=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://192.168.1.112/bz?useUnicode=true&characterEncoding=utf-8", "root", "root");
			cs=conn.prepareCall("{call p_5(?)}");
			
			cs.setInt(1, 20005);
			boolean hasresult=cs.execute();
			while(hasresult){
				
				rs=cs.getResultSet();
				
				while(rs.next()){
					System.out.println(rs.getFloat("o.item_price")+"----"+rs.getString("p.prod_name"));					
				}							
				hasresult=cs.getMoreResults();
			}			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					cs.close();
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
			
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
		
	}
	
private static void execFun() {//Function过程
		
		Connection conn=null;
		CallableStatement cs=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://192.168.1.112/bz?useUnicode=true&characterEncoding=utf-8", "root", "root");
			cs=conn.prepareCall("{?=call f_5(?,?)}");
			cs.registerOutParameter(1, java.sql.Types.FLOAT);
			cs.setInt(2, 20005);
			cs.setFloat(3, 0.1f);
			cs.execute();
			System.out.println(cs.getFloat(1));			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					cs.close();
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
			
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
		
	}
	private static void update() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://192.168.1.112/bz?useUnicode=true&characterEncoding=utf-8", "root", "root");
			String sql="update company set fname=? ,email=? where id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "阿里");
			pstmt.setString(2, "163.com");
			pstmt.setInt(3, 4);
			System.out.println(pstmt.executeUpdate()>0?"成功":"失败");
			
			
			
			
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
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
		
		
	}
	
	
	private static void del() {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://192.168.1.112/bz?useUnicode=true&characterEncoding=utf-8", "root", "root");
			String sql="delete from company where id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, 3);
			System.out.println(pstmt.executeUpdate()>0?"成功":"失败");
			
			
			
			
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
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
	}
	private static void add() {
		Connection conn=null;
		PreparedStatement pstmt=null;		
		try {
			String c="百度111";
			Class.forName("org.gjt.mm.mysql.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://192.168.1.112/bz?useUnicode=true&characterEncoding=utf-8", "root", "root");
			//conn.setAutoCommit(false);
			//insert into company(fname) values('百度');
			//防止sql注入
			pstmt=conn.prepareStatement("insert into company(fname,email) values(?,?)");
			pstmt.setString(1, c);
			pstmt.setString(2, "www@123.com");			
			System.out.println(pstmt.executeUpdate()>0?"成功":"失败");
			//conn.commit();			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
//			try {
//				//conn.rollback();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			
		}finally{
			try {				
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	/**
	 * 
	 */
	private static void query() {
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
			String sql="select * from products  ";
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
