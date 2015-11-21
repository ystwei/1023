package com.weikun.b;
public class B {
	public static void go(){//类方法
		
	}
	B(){
		
	}
	public static int age;//类属性
	public static void main(String[] args) {//static->dynamic
		age=100;
		B.age=200;
		go();
		
		B.go();
		new B().go();
	}
}
