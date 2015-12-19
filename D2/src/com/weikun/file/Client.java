package com.weikun.file;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		Socket client=null;
		DataInputStream dis=null;
		DataOutputStream dos=null;	
		try {
			
			client=new Socket("127.0.0.1",8221);
			
			dis=new DataInputStream(new BufferedInputStream(client.getInputStream()));
			
			String name=dis.readUTF();
			
			File file=new File(name);
			
			dos=new DataOutputStream(new FileOutputStream(file));
			
			int n=-1;
			byte[] buffer=new byte[1024];
			
			while((n=dis.read(buffer))!=-1){
				dos.write(buffer, 0, n);
			}
			System.out.println("成功接受");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				dis.close();
				dos.flush();
				dos.close();
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
}
