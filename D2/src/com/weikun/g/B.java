package com.weikun.g;

import java.util.Enumeration;
import java.util.Vector;

public class B {//generic raw parametied
	public static void main(String[] args) {
		Vector<String> v=new Vector<String>();//list
		//template
		v.add("A");
		v.add("B");
		v.add("C");
		v.add("D");
		
		Enumeration<String> e=v.elements();
		
		while(e.hasMoreElements()){
			System.out.println(e.nextElement());
		}
		
	}
}
