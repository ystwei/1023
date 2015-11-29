package com.weikun.e;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class B {
	public static void main(String[] args) {
		new B().copy();
	}
	public void copy(){
		Reader r=null;
		Writer w=null;
		try {
			r=new FileReader("c://2.txt");
			w=new FileWriter("d://4.txt");
			int n=-1;
			char buffer[]=new char[1024];
			
			while((n=r.read(buffer))!=-1){
				w.write(buffer, 0, n);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				
				w.flush();
				w.close();
				r.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void write(){
		Writer w=null;
		try {
			w=new FileWriter("d://3.txt");
			w.write("Œ“‘⁄≥§¥∫£°");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				w.flush();
				w.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void read(){
		Reader r=null;
		char buffer[]=new char[1024];
		int n=-1;
		try {
			r=new FileReader("c:\\2.txt");
			while((n=r.read(buffer))!=-1){
				
				System.out.print(buffer);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				r.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
