package com.weikun.staproxy;

import com.weikun.staproxy.Subject;

public class Proxy implements Subject {
	private Subject rs=null;
	public Proxy(Subject rs){
		this.rs=rs;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Í³Ò»»Ø¸´£º");
		this.rs.print();
	}

}
