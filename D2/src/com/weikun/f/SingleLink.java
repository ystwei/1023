package com.weikun.f;







public class SingleLink<T> {
	private class Node{
		//保存节点的数据
		private T data;
		//指向下个节点的引用
		private Node next;

		//初始化全部属性的构造器
		public Node(T data , Node next)	{
			this.data = data;//当前节点的数据
			this.next = next;//当前节点的下一节点
		}

	}
	//保存该链表的头节点
	private Node header;
	//保存该链表的尾节点
	private Node tail;
	//保存该链表中已包含的节点数
	private int size;
	//创建空链表
	public SingleLink() {
		// TODO Auto-generated constructor stub
		header=null;
		tail=null;
	}
	//返回链表的长度	
	public int length(){
		return size;
	}
	public Node getNodeByIndex(int index){//根据索引号，找到节点
		if(index<0||index>size-1){
			System.out.println("这是不允许的，你傻啊");
			return null;//代表以上原因

		}
		Node cur=header;
		for(int i=0;i<size;i++){
			if(cur==null){
				break;//没找到，
			}

			if(i==index){//找到了
				return cur;
			}

			cur=cur.next;//依次往前走

		}
		return null;
	}
	//根据元素找到索引号
	public int findElement(T element){

		Node cur=header;
		for(int i=0;i<size;i++){
			if(cur==null){
				break;//没找到，
			}

			if(cur.data.equals(element)){//找到了
				return i;
			}			
			cur=cur.next;//依次往前走			
		}
		return -1;
	}
	public void addTail(T element){		
		if(header==null){			
			header=new Node(element,null);			
			this.tail=header;
		}else{//以前就有节点			
			Node nnode=new Node(element,null);//由于是增加到尾
			tail.next=nnode;
			tail=nnode;	
		}
		size++;
	}
	public void addHeader(T element){
		header=new Node(element,header);

		if(tail==null){
			tail=header;
		}
		size++;

	}
	public void insert(T element ,int index){
		if(index<0||index-size>0){
			System.out.println("这是不允许的，你傻啊");
			return ;//代表以上原因

		}
		if(header==null){
			this.addTail(element);
		}else{
			if(index==0){
				this.addHeader(element);
			}else{

				// 找到要插入索引号的前一节点
				Node prev=this.getNodeByIndex(index-1);
				prev.next=new Node(element,prev.next);

			}

		}
		size++;


	}
	public T del(int index){
		if(index<0||index-size>0){
			System.out.println("这是不允许的，你傻啊");
			return null;//代表以上原因

		}
		Node del=null;
		if(index==0){
			header=header.next;
		}else{
			Node prev=this.getNodeByIndex(index-1);//找到要删除点的前一节点
			del=prev.next;
			prev.next=del.next;
			del.next=null;

		}
		size--;
		return del.data;
	}
	//判断链式线性表是否为空表
	public boolean empty(){
		return size == 0;
	}
	//清空线性表
	public void clear(){
		//header、tail赋为null
		header = null;
		tail = null;
		size = 0;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		for(Node cur=header;cur!=null;cur=cur.next){
			sb.append(cur.data);
		}
		
		
		return sb.toString();
	}
	public static void main(String[] args) {
		SingleLink<String> list = new SingleLink<String>();
		list.insert("aaaa" , 0);
		list.addTail("bbbb");
		list.addTail("cccc");
		System.out.println("原始的链表："+list);
		
		
		//在索引为1处插入一个新元素
		list.insert("dddd" , 1);
		//输出顺序线性表的元素
		System.out.println("插入之后的链表："+list);
		//删除索引为2处的元素
		list.del(2);
		System.out.println("删除之后的链表："+list);
		//获取cccc字符串在链表中的位置
		System.out.println("cccc在链表中的位置：" 
			+ list.findElement("cccc"));
		System.out.println("链表中索引2处的元素：" 
			+ list.getNodeByIndex(2));
	}
}
