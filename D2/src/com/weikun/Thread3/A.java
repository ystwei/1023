package com.weikun.Thread3;

public class A implements Runnable{
	public static void main(String[] args) {
		new A().go();
	}
	public void go(){
		ThreadGroup tg=new ThreadGroup("ื้1ฃบ");
		Thread t=new Thread(tg,this);
		t.setName("A");
		t.start();
		
		
		Thread t1=new Thread(tg,this);
		t1.setName("B");
		t1.start();
		
		System.out.println("---------------"+tg.activeCount());
		
		
		Thread[] ts=new Thread[tg.activeCount()];
		
		int count=tg.enumerate(ts);
		
		for(int i=0;i<count;i++){
			System.out.println(ts[i].getName()+">>>>>>>>>>>>>>>>>>>>>>>>>>");
			
		}
		
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}
