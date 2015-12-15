package com.weikun.h;

public class D extends Thread {//用户线程，主线程
	public static void main(String[] args) {
		D d=new D();
		d.setName("A");
		d.start();
		D d1=new D();
		d1.setName("B");
		d1.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+":"+ i);
		}
	}

}
