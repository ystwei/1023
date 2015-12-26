package com.weikun.observer;

public class Test {
	public static void main(String[] args) {
		ConcreteSubject s=new ConcreteSubject();
		s.setSubjectState("AB他在哪里！");
		
		s.attach(new ConcreteObserver(s,"袁梦"));
		
		ConcreteSubject s1=new ConcreteSubject();
		s1.setSubjectState("FBB他在哪里！");
		
		s.attach(new ConcreteObserver(s1,"吴启帆"));
		
		s.attach(new ConcreteObserver(s,"刘静怡"));
		s.attach(new ConcreteObserver(s,"周立彬"));
		
		
		s.Notify();
		System.out.println("-----------");
		s.dettach(0);
		s.setSubjectState("小明他在哪里！");
		s.Notify();
	}
	
}
