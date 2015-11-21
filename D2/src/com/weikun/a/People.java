package com.weikun.a;

public class People extends Parent{
	{
		System.out.println("2");	
	}
	static{
		System.out.println("3");
	}	
	People(){
		this(100);
		System.out.println("1");
	}
	People(int old){
		super(100);
		System.out.println("6");
	}
	public static void main(String[] args) {
		new People();
	}
}
class Parent{
	{
		System.out.println("4");	
	}
	static{
		System.out.println("5");
	}
	Parent(int old){
		System.out.println("7");	
	}
	Parent(){
		System.out.println("8");	
	}
}
