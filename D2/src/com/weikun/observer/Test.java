package com.weikun.observer;

public class Test {
	public static void main(String[] args) {
		ConcreteSubject s=new ConcreteSubject();
		s.setSubjectState("AB�������");
		
		s.attach(new ConcreteObserver(s,"Ԭ��"));
		
		ConcreteSubject s1=new ConcreteSubject();
		s1.setSubjectState("FBB�������");
		
		s.attach(new ConcreteObserver(s1,"������"));
		
		s.attach(new ConcreteObserver(s,"������"));
		s.attach(new ConcreteObserver(s,"������"));
		
		
		s.Notify();
		System.out.println("-----------");
		s.dettach(0);
		s.setSubjectState("С���������");
		s.Notify();
	}
	
}
