package com.weikun.z;

public class Singleton {//���ӵ�һ��
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
