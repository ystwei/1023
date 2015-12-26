package com.weikun.z;
//单子模式的第三种，静态内部类实现
public class Singeleton2 {
	private static class Singleholder{
		private static final Singeleton2 s=new Singeleton2();
	}
	public static  Singeleton2 getInstance(){
		return Singleholder.s;
	}
	private Singeleton2(){
		
	}
	
}
