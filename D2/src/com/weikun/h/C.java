package com.weikun.h;

import java.lang.reflect.Array;

public class C {
	
	
	public static void main(String[] args) {
		//String [] ss=new String[]{"ABC","C","DEF"};
		Object o=Array.newInstance(String.class, 3);
		
		Array.set(o, 0, "ABC");
		Array.set(o, 1, "C");
		Array.set(o, 2, "DEF");
		
		
		for(int i=0;i<3;i++){
			System.out.println(Array.get(o, i));
		}
		
	}
}
