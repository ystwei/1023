package com.weikun.g;

public class E {
	/*
	 * 
	 * 写一个正则，要求满足
		.11
		0.11
		999.12
		8.134
		9.1578
	 */
	public static void main(String[] args) {
		//1 01 10 11 12
	//	System.out.println("0".matches("^[0-9]{0,3}\\.[1-9]{2,4}$"));
	//	System.out.println("0".matches("^0?[1-9]|1[0-2]$"));
		//String regex="^\\d*(\\.)?([1,9])+$";
		//System.out.println("0.12".matches(regex));
		
		System.out.println("12".matches("^0[1-9]|[1-9]|10|11|12$"));
	}
}
