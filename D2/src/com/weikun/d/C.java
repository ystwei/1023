package com.weikun.d;

public class C {
	public static void main(String[] args) {
		//1�β������ڲ���
		new C().go(new IC(){
			@Override
			public void plan() {
				// TODO Auto-generated method stub
				System.out.println("Anonymous:plan");
			}
		},"����");		
		//2����ֵ�����ڲ���
		new C().mark().plan();	
		//3ʵ���������ڲ���		
		new IC(){
			@Override
			public void plan() {
				// TODO Auto-generated method stub
				System.out.println("Anonymous:plan");
			}
		}.plan();
	}
	public void go(IC c,String name){
		c.plan();
	}
	public IC mark(){
		return new IC(){
			@Override
			public void plan() {
				// TODO Auto-generated method stub
				System.out.println("Anonymous:plan");
			}		
		};
	}
}

interface IC{
	void plan();
}
