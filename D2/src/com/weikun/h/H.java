package com.weikun.h;

public class H {
	public static void main(String[] args) {
		
		for(int i=0;i<100;i++){
			if(i==50){
				H1 h1=new H1();
				h1.setName("user:");
				h1.start();
				try {
					h1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+":"+ i);
		}
		
	}
}
class H1 extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+":"+ i);
		}
	}
}