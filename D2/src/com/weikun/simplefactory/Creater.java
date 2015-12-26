package com.weikun.simplefactory;

public class Creater {
	public IProduct sale(int p){
		switch (p) {
		case 1:
			return new ProductA(); 
			
		case 2:
			return new ProductB(); 
		default:
			return null;
		}
		
	}
}
