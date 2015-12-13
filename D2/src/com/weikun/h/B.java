package com.weikun.h;

public class B {
	public static void main(String[] args) {
		B b=new B();
		b.go(1,2,3,4,5);
		
	}
	public void go(int ... i){
		int sum=0;
		for(int a=0;a<i.length;a++){
			sum+=i[a];
			
		}
		System.out.println(sum);
		
	}
}
