package com.weikun.f;



public class LinkQueue <T>{

	private class Node{
		public  T data;
		public Node next;
		public Node(T data,Node next){
			this.data=data;
			this.next=next;
		}
	}
	//保存该链队列的头节点
	private Node front; 
	//保存该链队列的尾节点
	private Node rear;
	//保存该链队列中已包含的节点数
	private int size;
	
	
	
	public LinkQueue(T element){
		this.front=new Node(element,null);//只有一个节点，因此没有下一个节点，next=null
		this.rear=this.front;
		size++;
	}
	
	//队列有几个数据
	public int length(){
		return size;
		
	}
	
	public void add(T element){
		if(front==null){//没节点，需要加第一个节点
			front=new Node(element,null);
			this.rear=this.front;
		}else{//以前有节点，需要把rear指针移至新节点
			Node newnode=new Node(element,null);//null:因为他在rear上追加，没有下一节点
			rear.next=newnode;
			rear=newnode;		
		}
		size++;
	}
	
	public T remove(){//返回删除的那个数据
		Node old=front;
		front=front.next;
		old.next=null;
		size--;
		
		return old.data;
		
	}
	
	
	public T element(){
		return rear.data;
	}
	public boolean empty(){		
		return size==0;
	}
	public void clear(){
		front=null;
		rear=null;
		size=0;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		for(Node current=front;current!=null;current=current.next){
			sb.append(current.data+",");
			
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		LinkQueue <Integer> l=new LinkQueue<Integer>(100);
		l.add(200);
		l.add(300);
		l.remove();
		l.add(400);
		
		System.out.println(l);
	}
}
