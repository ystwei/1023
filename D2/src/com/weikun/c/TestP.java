package com.weikun.c;

public class TestP {
	public void  bark(IOld g){
		g.ok();
	}
	public IOld plan(int i){
		switch (i) {
		case 1:
			return new Parent();
			
		case 2:
			return new Student();
		case 3:
			return new Girl();
		case 4:
			return new Person();
		default:
			break;
		}
		return new Girl();
	}
	public static void main(String[] args) {
		TestP p=new TestP();
		
		
		p.plan(3).ok();
		
		Girl g=new Girl();
		Student s=new Student();
		Person t=new Person();
		Parent o=new Parent();
		p.bark(o);
		p.bark(g);
		p.bark(s);//Parent g=new Student();
		p.bark(t);
	}
}
