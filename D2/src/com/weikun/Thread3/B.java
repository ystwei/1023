package com.weikun.Thread3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class B {
	public static void main(String[] args) {
		ExecutorService service=Executors.newFixedThreadPool(1) ;
		
		for(int i=0;i<100;i++){
			
			
			
			service.execute(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName());
				}
				
				
				
			});
			
			
			
		}
		service.shutdown();
		
		try {
			service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("¹Ø±Õ³É¹¦");
	}
}
