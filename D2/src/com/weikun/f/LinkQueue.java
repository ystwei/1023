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
	//����������е�ͷ�ڵ�
	private Node front; 
	//����������е�β�ڵ�
	private Node rear;
	//��������������Ѱ����Ľڵ���
	private int size;
	
	
	
	public LinkQueue(T element){
		this.front=new Node(element,null);//ֻ��һ���ڵ㣬���û����һ���ڵ㣬next=null
		this.rear=this.front;
		size++;
	}
	
	//�����м�������
	public int length(){
		return size;
		
	}
	
	public void add(T element){
		if(front==null){//û�ڵ㣬��Ҫ�ӵ�һ���ڵ�
			front=new Node(element,null);
			this.rear=this.front;
		}else{//��ǰ�нڵ㣬��Ҫ��rearָ�������½ڵ�
			Node newnode=new Node(element,null);//null:��Ϊ����rear��׷�ӣ�û����һ�ڵ�
			rear.next=newnode;
			rear=newnode;		
		}
		size++;
	}
	
	public T remove(){//����ɾ�����Ǹ�����
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
