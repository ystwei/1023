package com.weikun.Thread3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class C {
	public static void main(String[] args) {
		ExecutorService service=Executors.newCachedThreadPool();
		List<Future<String>> list=new ArrayList<Future<String>>();
		
		for(int i=0;i<3;i++){
			
			Future<String> fs=service.submit(new MyCall());
			list.add(fs);
			
		}
		for(Future<String> f :list){
			try {
				System.out.println(f.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class MyCall implements Callable<String>{

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"执行了!");
		return "完成";
	}
	
}
