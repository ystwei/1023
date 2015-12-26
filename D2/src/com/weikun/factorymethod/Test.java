package com.weikun.factorymethod;

public class Test {
	public static void main(String[] args) {
		Customer c=new Alice();
		c.eat().beieat();
		
		
		Customer c1=new Rose();
		c1.eat().beieat();
	}
}
