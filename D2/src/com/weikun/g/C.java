package com.weikun.g;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class C {
	
	public static void main(String[] args) {
		//HashMap
		Hashtable<String,Integer> t=new Hashtable<String,Integer>();
		t.put("AB", 2);	
		t.put("YM", 5);
		t.put("WK", 3);
		Enumeration<Integer> es=t.elements();
		
		while(es.hasMoreElements()){
			System.out.println(es.nextElement());
		}
		System.out.println("----");
		
		Enumeration<String> k=t.keys();
		while( k.hasMoreElements()){
			System.out.println(t.get(k.nextElement()));
		}
		System.out.println("----");
		Collection<Integer> cs=t.values();
		
		for(Integer i :cs){
			System.out.println(i);
		}
		System.out.println("----");
		
		Set <String> ss=t.keySet();
		Iterator<String> it=ss.iterator();
		while( it.hasNext()){
			System.out.println(t.get(it.next()));
		}
		System.out.println("----");
		Set<Map.Entry<String,Integer>> ts=t.entrySet();
		
		Iterator<Map.Entry<String,Integer>> it2=ts.iterator();
		
		while(it2.hasNext()){
			Entry<String,Integer> e=it2.next();
			System.out.println(e.getKey()+"--"+e.getValue());
			
		}
		
		
	}
	
	
}
