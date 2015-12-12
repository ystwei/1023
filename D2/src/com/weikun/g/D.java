package com.weikun.g;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class D {
	public static void main(String[] args) {
		Hashtable<String,Integer> t=new Hashtable<String,Integer>();
		t.put("AB", 2);	
		t.put("YM", 5);
		t.put("WK", 3);
		
		List<Map.Entry<String,Integer>> list=new ArrayList<Map.Entry<String,Integer>>(t.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String,Integer>>(){

			@Override
			public int compare(Entry<String, Integer> o1,
					Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				
				return o1.getValue().compareTo(o2.getValue());
			}		
			
			
		});
		for(Map.Entry<String,Integer> m :list){
			System.out.println(m.getKey()+"--"+m.getValue());
		}
		
		
		HashSet s=new HashSet();
		
		s.add("A");
		s.add("B");
		s.add("C");
		s.add("D");
		
		Iterator it=s.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
}
