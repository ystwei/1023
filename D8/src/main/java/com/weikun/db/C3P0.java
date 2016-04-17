package com.weikun.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0 {
	private static Connection conn;
	private static ComboPooledDataSource ds=null;
	static{
		ds=new ComboPooledDataSource("mysql");		
		
	}
	
	public static Connection getConnection(){
		
		try {
			conn=ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) {
		System.out.println(C3P0.getConnection());
	}
}
