package com.weikun.h;

public class I extends Thread{
	public static void main(String[] args) {
		I1 i=new I1();
		i.setName(" ÿª§£∫");
		i.setDaemon(true);
		i.start();
		
		I i1=new I();
		i1.setName("”√ªß£∫");
		i1.start();
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+":"+ i);
		}
	}
}
class I1 extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<1000;i++){
			System.out.println(Thread.currentThread().getName()+":"+ i);
		}
	}
}
