package com.weikun.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		ServerSocket server=null;
		Socket client=null;
		try {
			server=new ServerSocket(9102);
			client=server.accept();
			boolean flag=true;
			
			BufferedReader reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
			while(flag){
				String s=reader.readLine();
				if(s.trim().toLowerCase().equals("q")){
					flag=false;
				}else{
					System.out.println("¿Í»§¶ËËµ£º"+s);
				}
				
				
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				client.close();
				server.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
}
