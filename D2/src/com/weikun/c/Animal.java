package com.weikun.c;

public  abstract class Animal {
	public abstract void tongyi();
	public void go(){//һ�㷽��
		bark();
	}
	public static void main(String[] args) {		 
		 
	}
	protected  void bark(){
		
	}
	public int age=100;
}
class Cat extends Animal{

	@Override
	public void tongyi() {
		// TODO Auto-generated method stub
		age=200;
	}
	
}