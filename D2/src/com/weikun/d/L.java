package com.weikun.d;

public class L {
	public static void main(String[] args) {
		House h=new House();
		h.address="¹þ¶û±õ";
		Cat c=new Cat("Ã¨",h);		
		try {
			Cat c1=(Cat)c.clone();//fleet clone			
			System.out.println(c1.name);			
			c1.h.address="ºÚÁú½­";
			System.out.println(c.h.address);			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class House implements Cloneable{
	public String address;	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
class Cat implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Cat c2=(Cat)super.clone();
		c2.h=(House)c2.h.clone();
		return c2;
	}	
	public String name;
	public House h;
	public Cat(String name,House h){
		this.h=h;
		this.name=name;
	}
}