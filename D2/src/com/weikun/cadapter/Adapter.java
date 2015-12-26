package com.weikun.cadapter;

//public class Adapter extends Adaptee implements Target {
public class Adapter  implements Target {
	private Adaptee t=new Adaptee();
	@Override
	public void request() {
		// TODO Auto-generated method stub
		t.myRequest();
		System.out.println("ÎÒÄÜ³äµç£¡");
	}

}
