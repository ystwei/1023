package com.weikun.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class D {
	public static void main(String[] args) {
		Path p=Paths.get("d://video//1023///线程1.wmv");
		
		try {
			AsynchronousFileChannel as=AsynchronousFileChannel.open(p, StandardOpenOption.READ);
			Future<Integer> f=as.read(ByteBuffer.allocate(1024*1024*10),0);
			
			while(!f.isDone()){
				
				System.out.println("卫老师");
				
			}
			Integer bytesRead=f.get();
			System.out.println("read:["+bytesRead+"]");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
}
