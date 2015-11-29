package com.weikun.e;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class A {	
	public void read(){
		InputStream is=null;
		try {
			is=new FileInputStream("c:\\2.txt");//形参是你要打开的文件名字 2.3 
			byte[] buffer=new byte[1024];
			int n=-1;
			int i=0;
			try {
				while((n=is.read(buffer))!=-1){
					System.out.write(buffer, 0, n);
					i++;
				}
				System.out.println(">>>>"+i);
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void copy(){
		InputStream is=null;
		OutputStream os=null;
		long start=System.currentTimeMillis();
		
		try {			
			is=new FileInputStream("c:\\1.wmv");
			os=new FileOutputStream("d://2.wmv");
			byte[] buffer=new byte[1024*1024];
			int n=-1;
			while( (n=is.read(buffer))!=-1){
				
				os.write(buffer, 0, n);
			}
			
			long end=System.currentTimeMillis();	
			
			System.out.println((end-start)/1000);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				is.close();
				os.flush();
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	public void write(){
		OutputStream os=null;
		try {
			os=new FileOutputStream("c://666.txt",true);
			
			os.write("我们在哈尔滨！".getBytes("utf-8"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				os.flush();
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public static void main(String[] args) {
		new A().copy();
		
	}
}
