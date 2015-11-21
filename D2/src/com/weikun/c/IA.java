package com.weikun.c;

public interface IA  {
	void go();//接口的方法都是抽象的，public
	int age=100;

}
interface IB {
	void bark();
}
interface IC{
	void plan();
}
class B0{
	public void eatMilk() {
		// TODO Auto-generated method stub
		
	}
}
class B extends B0 implements IA,IB,IC {

	@Override
	public void go() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bark() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void plan() {
		// TODO Auto-generated method stub
		
	}
	
}
