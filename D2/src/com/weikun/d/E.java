package com.weikun.d;

import java.math.BigDecimal;

public class E {
	public static void main(String[] args) {
//		System.out.println(Math.ceil(2.4));
//		System.out.println(Math.floor(2.4));
//		System.out.println(Math.pow(2, 3));
		
		
//		for(int i=0;i<10;i++){
//			//[A,Z][65,90]
//			//System.out.println( Math.floor(Math.random()*5+6 ));//[6,11.0) ->[5.0~,10.~] [6~,10~]
//			System.out.println((char)(Math.random()*26+65));//[ ]
//			
//		}
		
		System.out.println(Math.round(3.533));
		BigDecimal b=new BigDecimal(00099.915);
		System.out.println(b.setScale(-2, BigDecimal.ROUND_HALF_UP));//Àƒ…·ŒÂ»Î
		
		
	}
}
