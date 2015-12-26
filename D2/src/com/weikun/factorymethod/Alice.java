package com.weikun.factorymethod;

public class Alice implements Customer {

	@Override
	public Hanbao eat() {
		// TODO Auto-generated method stub
		return new JuwubaHanbao();
	}

}
