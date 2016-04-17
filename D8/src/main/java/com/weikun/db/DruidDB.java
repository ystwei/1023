package com.weikun.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidDB {
	private static DataSource ds;
	private static Connection conn;
	static{
		InputStream is=DruidDB.class.getClassLoader().getResourceAsStream("druid.ini");
		
		Properties pro=new Properties();
		
		try {
			pro.load(is);
			ds=DruidDataSourceFactory.createDataSource(pro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		System.out.println(DruidDB.getConnection());
	}
}
