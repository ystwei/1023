package com.weikun.f;

import java.util.Stack;

public class MinStack {
	/*
	 * ����ջ����СԪ��
	 * 
	 */
	private Stack<Integer> data;//����ջ
	private Stack<Integer> min;//��Сջ
	
	public MinStack(){
		data=new Stack<Integer>();
		min=new Stack<Integer>();
	}
	public int getMin(){
		
		if(min.isEmpty()){
			System.out.println("��ûֵ�ǣ�");
		}
			
		return  min.peek();
		
	}
	public int pop(){
		if(min.isEmpty()){
			System.out.println("��ûֵ�ǣ�");
		}
		return data.pop();
	}
	public void push(int i){
		if(min.isEmpty()){
			min.push(i);
		}else if(i<this.getMin()){
			min.push(i);
		}
		
		
		data.push(i);
	}
	public static void main(String[] args) {
		MinStack m=new MinStack();
		m.push(2);
		m.push(1);
		m.push(3);
		m.push(-1);
		m.push(0);
		m.push(5);
		
		
		System.out.println(m.getMin());
	}
	
}
