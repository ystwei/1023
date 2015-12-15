package com.weikun.h;

public class G extends Thread {
	public static void main(String[] args) {
		G g=new G();
		g.setName("A:");
		g.start();
		
		
		G g1=new G();
		g1.setName("B:");
		g1.start();
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+":"+ i);
			try {
				Thread.currentThread().sleep(200);
				Thread.currentThread().yield();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
}
