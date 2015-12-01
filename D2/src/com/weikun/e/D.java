package com.weikun.e;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
public class D {
	public static void main(String[] args) {
		in3();
		
	}
	private static void in3() {//ת����
		BufferedReader br=null;		
		try {
			br=new BufferedReader(new InputStreamReader(System.in));
			while(true){				
				System.out.println(br.readLine());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				br.close();				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	private static void in2() {//�ֽ�����
		InputStream is=System.in;
		byte[] buffer=new byte[1024];
		try {
			while(true){
				try {
					is.read(buffer);
					System.out.println(new String(buffer).trim());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
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
	/**
	 * 
	 */
	private static void in1() {//system.in
		Scanner sc=new Scanner(System.in);
		
		while(true){
			String line=sc.nextLine();//һ��Ҫ����������ֵ���ͣ�����������
			if(line.toLowerCase().trim().equals("q")){
				//break;
				System.exit(0);
				
			}
			System.out.println(line);
			
		}
	}
}
