package com.weikun.f;

import java.util.Arrays;

public class SequenceQueue <T>{
	//Ĭ�ϳ���
	private int DEFAULT_SIZE = 10;
	//��������ĳ��ȡ�
	private int capacity;
	//����һ���������ڱ���˳����е�Ԫ��
	private Object[] elementData;
	//����˳�������Ԫ�صĵ�ǰ����
	private int front = 0;//��
	private int rear = 0;//��
	
	public SequenceQueue(){
		this.capacity=this.DEFAULT_SIZE;
		elementData=new Object[this.capacity];
	}
	public int length(){
		
		return this.rear-this.front;//��ʵ���ȣ�
	}
	public void add(T data){//�ڶ�β����Ԫ��
		if(rear-(this.capacity-1)>0){//
			System.out.println("��ܰ��ʾ��Խ���ˣ�");
			return;
		}
		elementData[rear++]=data;
	}
	public T remove(){//ɾ�����еĵ�һ��Ԫ��
		if(this.empty()){
			System.out.println("����Ϊ��");	
			return null;
		}
		
		T old=(T)elementData[front];
		elementData[front++]=null;
		
		return old;
	}
	public T elemet(){//���ض��еĵ�һ��Ԫ��
		if(this.empty()){
			System.out.println("����Ϊ��");	
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
