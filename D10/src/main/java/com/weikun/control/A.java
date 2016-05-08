package com.weikun.control;

import java.util.HashMap;
import java.util.Map;

public class A {
	public static void main(String[] args) {
		 Map<String,String> map=new HashMap<String,String>();
		 map.put("A", "B");
		 map.put("A", "C");
		 System.out.println(map.get("A"));
	}
}
