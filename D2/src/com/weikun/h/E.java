package com.weikun.h;

public class E implements Runnable{
	public static void main(String[] args) {
		E e =new E();
		Thread t=new Thread(e);
		t.setName("A");
		t.setPriority(Thread.NORM_PRIORITY);
		t.start();
		
		
		E e1 =new E();
		Thread t1=new Thread(e1);
		t1.setName("B");
		t1.setPriority(Thread.NORM_PRIORITY+2);
		t1.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++){
			if(i==50){
				
			}
			System.out.println(Thread.currentThread().getName()+":"+ i);
		}
	}

}
