package com.weikun.nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class B {
	public static void main(String[] args) {
		try {
			WatchService service=FileSystems.getDefault().newWatchService();
			Path p=FileSystems.getDefault().getPath("c://");
			
			WatchKey key=p.register(service, StandardWatchEventKinds.ENTRY_MODIFY );
			
			boolean flag=false;
			while(!flag){
				
				key=service.take();
				for(WatchEvent we : key.pollEvents()){
					
					if(we.kind()==StandardWatchEventKinds.ENTRY_MODIFY ){
						System.out.println("你发誓了改变");					
					}
				}
				key.reset();
				flag=true;
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}	
