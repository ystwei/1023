package com.weikun.nio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class E {
	public static void main(String[] args) {
		Path p=Paths.get("c://1.txt");
		
		try {
			AsynchronousFileChannel as=AsynchronousFileChannel.open(p, StandardOpenOption.READ);
			
			as.read(ByteBuffer.allocate(1024*1024), 0,null,new CompletionHandler<Integer, A>() {

				@Override
				public void completed(Integer result, A attachment) {
					// TODO Auto-generated method stub
					System.out.println("≥…π¶¡À");
				}

				@Override
				public void failed(Throwable exc, A attachment) {
					// TODO Auto-generated method stub
					
				}
				
				
			});
			
			as.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			
		}
	}
}
