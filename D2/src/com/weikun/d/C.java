package com.weikun.d;

public class C {
	public static void main(String[] args) {
		//1形参匿名内部类
		new C().go(new IC(){
			@Override
			public void plan() {
				// TODO Auto-generated method stub
				System.out.println("Anonymous:plan");
			}
		},"北京");		
		//2返回值匿名内部类
		new C().mark().plan();	
		//3实例化匿名内部类		
		new IC(){
			@Override
			public void plan() {
				// TODO Auto-generated method stub
				System.out.println("Anonymous:plan");
			}
		}.plan();
	}
	public void go(IC c,String name){
		c.plan();
	}
	public IC mark(){
		return new IC(){
			@Override
			public void plan() {
				// TODO Auto-generated method stub
				System.out.println("Anonymous:plan");
			}		
		};
	}
}

interface IC{
	void plan();
}
