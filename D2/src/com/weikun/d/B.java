package com.weikun.d;

public class B {
	public void go(final String city){
		final int age=100;
		class B1{
			
			public void ok(){
				System.out.println(city);
			}
		}
		
		new B1().ok();
	}
}
