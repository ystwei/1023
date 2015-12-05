package com.weikun.f;

import java.util.Arrays;

public class SequenceQueue <T>{
	//默认长度
	private int DEFAULT_SIZE = 10;
	//保存数组的长度。
	private int capacity;
	//定义一个数组用于保存顺序队列的元素
	private Object[] elementData;
	//保存顺序队列中元素的当前个数
	private int front = 0;//出
	private int rear = 0;//进
	
	public SequenceQueue(){
		this.capacity=this.DEFAULT_SIZE;
		elementData=new Object[this.capacity];
	}
	public int length(){
		
		return this.rear-this.front;//真实长度，
	}
	public void add(T data){//在队尾增加元素
		if(rear-(this.capacity-1)>0){//
			System.out.println("温馨提示，越界了！");
			return;
		}
		elementData[rear++]=data;
	}
	public T remove(){//删除队列的第一个元素
		if(this.empty()){
			System.out.println("队列为空");	
			return null;
		}
		
		T old=(T)elementData[front];
		elementData[front++]=null;
		
		return old;
	}
	public T elemet(){//返回队列的第一个元素
		if(this.empty()){
			System.out.println("队列为空");	
			return null;
		}
		
		return (T)elementData[front];
	}
	public void clear(){
		Arrays.fill(elementData, null);
		this.rear=0;
		this.front=0;
	}
	public boolean empty(){		
		return this.rear==this.front;
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		for(int i=front;i<rear;i++){
			sb.append(elementData[i]+",");
		}
		
		
		return sb.toString();
	}
	public static void main(String[] args) {
		SequenceQueue s=new SequenceQueue();
		s.add(100);
		s.add(200);
		s.add(300);
		s.add(400);
		s.remove();
		s.add(500);
		System.out.println(s);
	}
}
