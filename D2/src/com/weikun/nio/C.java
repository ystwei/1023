package com.weikun.nio;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class C {
	public static void main(String[] args) {
		new C().read();
	}
	public void read(){
		ByteBuffer bb=ByteBuffer.allocate(1024);
		try {
			
			Path p=Paths.get("c://2.txt");
			FileChannel fc=FileChannel.open(p, StandardOpenOption.READ);
			fc.read(bb);
			bb.flip();
			Charset c=Charset.forName("utf-8");
			
			System.out.println(c.decode(bb));
			
			fc.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void write(){
		try {
			Path p=Paths.get("c://2.txt");
			FileChannel fc=FileChannel.open(p, StandardOpenOption.WRITE);

			fc.write(ByteBuffer.wrap("哈尔滨-北京".getBytes()));



		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
