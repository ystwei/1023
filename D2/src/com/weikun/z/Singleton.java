package com.weikun.z;

public class Singleton {//单子第一种
	private static Singleton ton=null;
	private Singleton(){
		
	}
	public static synchronized Singleton getInstance(){
		if(ton==null){
			ton=new Singleton();
			
		}
		return ton;
	}

}
