package com.weikun.f;

import java.util.LinkedList;

public class B {
	public static void main(String[] args) {
		LinkedList list=new LinkedList();//对数据进行增删，它的查询和遍历，比较麻烦（ArrayList）
		list.push(6);//stack
		list.offerFirst("1");//queue
		list.addFirst(4);//Collection
		list.offer("3");//queue
		list.addLast(5);	//	Collection
		list.offerLast("2");//queue
		list.offer("8");//queue
		list.push(7);		//stack
		System.out.println(">>>>>"+list.peek());//stack
		System.out.println(">>>>>"+list.peekFirst());//self
		System.out.println(">>>>>"+list.peekLast());//self		
		System.out.println(">>>>>"+list.pop());//stack
		System.out.println(">>>>>"+list.pop());//stack		
		System.out.println(">>>>>"+list.pollLast());//self
		System.out.println(">>>>>"+list.poll());//self
		System.out.println(">>>>>"+list.pollFirst());//self		
		System.out.println("remove:"+list.remove());	
		System.out.println("removeFirst:"+list.removeFirst());
		System.out.println("removeLast:"+list.removeLast());	
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		
	}
}
