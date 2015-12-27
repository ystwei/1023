package com.weikun.decorator;

public class Running extends GirlDecorator {
	
	private Girl girl;
	public Running(Girl girl){
		this.girl=girl;
	}
	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return this.girl.getDesc()+"--Œ“ª·≈‹≤Ω£°";
	}

}
