package com.weikun.c;

public class Person extends Parent  {
	public void ok(){
		System.out.println("person:ok");
	}
	public void go(){
		System.out.println("person:go");
	}
	public static void main(String[] args) {
//		Parent p=new Person();//1虚方法调用
//		((Person)p).go();
	}	
}
class Student extends Parent{
	public void ok(){
		System.out.println("Student:ok");
	}
}
class Girl extends Parent{
	public void ok(){
		System.out.println("Girl:ok");
	}
}

class Parent implements IOld{
	public void ok(){
		System.out.println("parent:ok");
	}	
}
interface IOld{
	public void ok();
}