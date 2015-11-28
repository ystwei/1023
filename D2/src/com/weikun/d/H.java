package com.weikun.d;

public class H {
	private int old;
	private String name;
	
	public H(int old, String name) {
		super();
		this.old = old;
		this.name = name;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this==obj){
			return true;
			
		}
		if(obj==null){
			
			return false;
		}
		if(this.getClass()!=obj.getClass()){
			return false;
		}
		H h=(H)obj;
		
		return this.old==h.old&&this.name.equals(h.name);
		
		
	}
	public static void main(String[] args) {
		H h=new H(100,"MIKE");
		H h1=new H(1001,"MIKE");
		System.out.println(h.equals(h1));
	}
}
