package com.weikun.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	public List<Observer> list=new ArrayList<Observer>();
	public void attach(Observer o){//收集观察者
		list.add(o);
		
	}
	public void dettach(int i){
		list.remove(i);
	}
	public void Notify(){
		for(Observer o :list){
			
			o.update();
		}
	}
}
