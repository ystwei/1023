package com.weikun.b;
public class B {
	public static void go(){//�෽��
		
	}
	B(){
		
	}
	public static int age;//������
	public static void main(String[] args) {//static->dynamic
		age=100;
		B.age=200;
		go();
		
		B.go();
		new B().go();
	}
}
