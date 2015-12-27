package com.weikun.staproxy;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subject s=new RealSubject();
		
		Proxy p=new Proxy(s);
		
		p.print();
		
	}

}
