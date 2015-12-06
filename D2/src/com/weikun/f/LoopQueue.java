package com.weikun.f;

public class LoopQueue<T> {
	//保存数组的长度。
	private int capacity;
	//定义一个数组用于保存循环队列的元素
	private Object[] elementData;
	//保存循环队列中元素的当前个数
	private int front = 0;
	//队尾
	private int rear = 0;
	public LoopQueue(T data,int initsize){
		this.capacity=initsize;
		elementData=new Object[initsize];
		elementData[0]=data;
		rear++;
		
	}
	public int length(){//循环队列的元素的长度
		
		return this.rear>this.front?this.rear-this.front:this.capacity-(this.front-this.rear);
		
	}
	public void add(T element){
//		if((rear==front)&&(elementData[front]!=null)){//一进来就满了
//			System.out.println("队列满了");
//			return;
//		}
		elementData[rear++]=element;
		rear= rear==this.capacity? 0:rear ;//经过++之后也可能满
		
	}
	public T remove(){
		
		if(empty()){			
			System.out.println("队列空的");
			return null;
		}
		
		T old=(T)elementData[front];//老元素
		
		elementData[front++]=null;//清空老元素，并且使front指向下一个
		
		front=front==this.capacity?0:front;//判断是否是全删完了
		
		return old;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		if(this.rear-this.front>0){
			
			for(int i=front;i<rear;i++){
				sb.append(elementData[i]);
			}
			
		}else{
			//有可能rear在不停地++，跃出了界限
			for(int i=front;i<capacity;i++){
				sb.append(elementData[i]);
			}
			for(int i=0;i<rear;i++){
				sb.append(elementData[i]);
			}
			
		}
		System.out.println(elementData.toString());
		return sb.toString();
	}
	public T element(){//返回队顶元素		
		
		return (T)elementData[front];
	}
	public boolean empty(){
		return rear==front&&elementData[rear]==null;
	}
	public static void main(String[] args) {
		LoopQueue l=new LoopQueue(100,3);
		l.add(200);
		l.add(300);
		l.add(400);
		l.remove();
		l.add(500);	
		System.out.println(l);
		
	}
}
