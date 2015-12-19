package com.weikun.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Socket client =null;
		try {
			client=new Socket("127.0.0.1",9102);
			PrintWriter out=new PrintWriter(client.getOutputStream(),true);
			Scanner sc=new Scanner(System.in);
			
			while(sc.hasNext()){
				String s=sc.nextLine();
				
				out.println(s);
			}
			sc.close();
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
