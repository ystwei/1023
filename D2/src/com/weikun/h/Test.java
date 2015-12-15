package com.weikun.h;

import java.util.Timer;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTask m=new MyTask();
		Timer timer=new Timer();
		m.setImgCount(10);
		m.setTimer(timer);
		
		
		timer.schedule(m, 1000, 100);
		
		
		
		MyTask m1=new MyTask();
		
		m1.setImgCount(10);
		m1.setTimer(timer);
		
		
		timer.schedule(m1, 1000, 500);
		
		
	}

}
