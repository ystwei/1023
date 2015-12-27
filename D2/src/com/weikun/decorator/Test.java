package com.weikun.decorator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Girl ag=new AmericanGirl();
//		System.out.println(ag.desc);
		
		Girl eg=new EuropeGirl();
		System.out.println(eg.desc);
		
		Coding c=new Coding(eg);
		System.out.println(c.getDesc());
//		
		Running r=new Running(c);
		System.out.println(r.getDesc());
		
	}

}
