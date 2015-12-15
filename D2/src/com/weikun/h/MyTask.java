package com.weikun.h;

import java.util.Timer;
import java.util.TimerTask;

public class MyTask extends TimerTask {
	private int imgCount;//总体图片数量
	private int imgCur=0;//当前图片号
	private Timer timer;
	
	public void setImgCount(int imgCount) {
		this.imgCount = imgCount;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub		
		if(imgCur++<this.imgCount){
			
			System.out.println("继续加载资源"+imgCur);
		}else{
			timer.cancel();
			System.out.println("加载成功！");
		}
	}

}
