package com.weikun.z;

public class Singleton3 {
	private volatile static Singleton3 s;
	private Singleton3(){
		
		
	}
	public static Singleton3 getInstance(){
		synchronized(Singleton3.class){
			if(s==null){
				
				s=new Singleton3();
			}
		}
		
		return s;
	}
}
