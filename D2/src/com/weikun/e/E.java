package com.weikun.e;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class E {
	public static void main(String[] args) {
		new E().merge();
	}
	public void merge(){
		RandomAccessFile in=null;
		RandomAccessFile out=null;
		File file=new File("c://2.mp3");
		try {
			in=new RandomAccessFile("c://1.mp3", "r");
			out=new RandomAccessFile(file, "rw");
			out.seek(file.length());
			int n=-1;
			byte[] buffer=new byte[1024];
			while( (n=in.read(buffer))!=-1){
				out.write(buffer, 0, n);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				out.close();
				in.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public void copy(){
		RandomAccessFile in=null;
		RandomAccessFile out=null;
		try {
			in=new RandomAccessFile("c://2.txt", "r");
			out=new RandomAccessFile("d://44.txt", "rw");
			int n=-1;
			byte[] buffer=new byte[1024];
			while( (n=in.read(buffer))!=-1){
				out.write(buffer, 0, n);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				out.close();
				in.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
