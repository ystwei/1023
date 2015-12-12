package com.weikun.g;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class A {
	
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();//数组列表
		
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");		
		
		Iterator<String> it=list.iterator();
		
		while(it.hasNext()){			
			String e=it.next();			
			System.out.println(e);
		}
		System.out.println("-----------");		
		
		for(String s  :list ){//foreach			
			System.out.println(s);			
		}
		System.out.println("-----------");
		
		
		ListIterator<String> lit=list.listIterator();
		
		while(lit.hasNext()){			
			String e=lit.next();			
			System.out.println(e);
		}
		
		while(lit.hasPrevious()){			
			String e=lit.previous();			
			System.out.println(e);
		}
		System.out.println("-----------");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		for(int i=list.size()-1;i>=0;i--){
			System.out.println(list.get(i));
		}
		System.out.println("-----------");
		
		Object []os=list.toArray();
		for(int i=0;i<os.length;i++){
			System.out.println(os[i]);
		}
		
		
		
	}
}
