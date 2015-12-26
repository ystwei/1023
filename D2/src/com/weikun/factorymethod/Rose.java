package com.weikun.factorymethod;

public class Rose implements Customer {

	@Override
	public Hanbao eat() {
		// TODO Auto-generated method stub
		return new TianyuanHanbao();
	}

}
