package com.weikun.observer;

public class ConcreteObserver extends Observer {
	private ConcreteSubject s;
	private String name;
	public ConcreteObserver(ConcreteSubject s,String name){
		this.s=s;
		this.name=name;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println(this.name+"ÖªµÀÁË:"+this.s.getSubjectState());
	}

}
