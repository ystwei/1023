package com.weikun.e;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C {
	public static void main(String[] args) {
		new C().bufferCopy();
	}
	public void bufferCopy(){
		
		FileInputStream fis=null;
		BufferedInputStream bis=null;//BufferedReader BufferedWriter
		
		FileOutputStream fos=null;
		BufferedOutputStream bos=null;
		try {
			fis=new FileInputStream("c://1.wmv");
			fos=new FileOutputStream("d://11.wmv");
			bis=new BufferedInputStream(fis, 1024*12);
			
			bos=new BufferedOutputStream(fos);
			
			
			byte[] buffer=new byte[1024];
			int n=-1;
			while((n=bis.read(buffer))!=-1){
				bos.write(buffer, 0, n);
			}
			
		} catch (Exception e) {
			// TODO: handl exception
			e.printStackTrace();
		}finally{
			try {
				bos.flush();
				bos.close();
				
				fos.flush();
				fos.close();	
				
				bis.close();
				fis.close();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
