package com.weikun.decorator;

public class Coding extends GirlDecorator {
	private Girl girl;
	public Coding(Girl girl){
		this.girl=girl;
	}
	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return this.girl.getDesc()+"--ÎÒ»á±àÂë";
	}

}
