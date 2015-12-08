package com.weikun.f;









public class DubLink<T> {
	//定义一个内部类Node，Node实例代表链表的节点。
	private class Node{
		//保存节点的数据
		private T data;
		//指向上个节点的引用
		private Node prev;
		//指向下个节点的引用
		private Node next;

		//初始化全部属性的构造器
		public Node(T data , Node prev , Node next){
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}
	//保存该链表的头节点
	private Node header;
	//保存该链表的尾节点
	private Node tail;
	//保存该链表中已包含的节点数
	private int size;
	//创建空链表
	public DubLink(){
		//空链表，header和tail都是null
		header = null;
		tail = null;
	}
	//返回链表的长度	
	public int length(){
		return size;
	}
	public Node getNodeByIndex(int index){
		if (index < 0 || index > size - 1){
			System.out.println("卫老师提示：线性表索引越界");
			return null;
		}

		if(index<=size/2){//从头部查
			Node cur=header;
			for(int i=0;i<=size/2&&cur!=null;i++,cur=cur.next){

				if(i==index){
					return cur;

				}
			}
		}else{
			Node cur=tail;
			for(int i=size-1;i>size/2&&cur!=null;i--,cur=cur.prev){

				if(i==index){
					return cur;

				}
			}
		}

		return null;

	}
	//查找链式线性表中指定元素的索引
	public int findElement(T element){

		Node cur=header;
		for(int i=0;i<size&&cur!=null;i++,cur=cur.next){

			if(cur.data.equals(element)){
				return i;

			}
		}
		return -1;
	}
	public void insert(T element , int index){
		if (index < 0 || index > size){
			System.out.println("卫老师提示：线性表索引越界");
		}else{
			if(header==null){
				this.addHeader(element);
			}else{
				if(index==0){
					this.addHeader(element);
				}else{
					
					//找到索引号的前一索引号指定的节点
					Node prev=this.getNodeByIndex(index-1);
					
					Node next=prev.next;
					
					if(next==null){
						this.addTail(element);
					}else{
						Node nnode=new Node(element,prev,next);
						prev.next=nnode;
						next.prev=nnode;
					}
				
					
					
					
					
					
				}
			}
		}
		size++;


	}
	public T delete(int index){
		Node del=null;
		if (index < 0 || index > size - 1){
			System.out.println("线性表索引越界");
		}
		if(index==0){//删除头部
			
			
			del=header;
			header.prev=null;
			header=header.next;
			del.next=null;
		}else{
			
			Node prev=this.getNodeByIndex(index-1);
			
			del=prev.next;
			
			prev.next=del.next;
			if(del.next!=null){
				del.next.prev=prev;
			}
			del.prev=null;
			del.next=null;
			
		}
		size--;
		return del.data;
		
	}
	//删除链式线性表中最后一个元素
    public T remove(){
		return delete(size - 1);
	}
	//判断链式线性表是否为空链表
	public boolean empty(){
		return size == 0;
	}
	//清空线性表
	public void clear(){
		//将底层数组所有元素赋为null
		header = null;
		tail = null;
		size = 0;
	}
	
	//采用尾插法为链表添加新节点。
	public void addTail(T element){
		if(header==null){
			header=new Node(element,null,null);
			tail=header;
			
		}else{
			Node nnode=new Node(element,tail,null);
			
			tail.next=nnode;
			tail=nnode;
			
			
		}
		size++;
	}
	//采用头插法为链表添加新节点。
	public void addHeader(T element){
		
		if(tail==null){
			tail=new Node(element,null,null);
			header=tail;
			
		}else{
			Node nnode=new Node(element,null,header);
			
			header.prev=nnode;
			header=nnode;
			
			
		}
		size++;
		
		
	}
	public String toString(){
		//链表为空链表时
		if (empty()){
			return "[]";
		}else{
			StringBuilder sb = new StringBuilder();
			for (Node current = header ; current != null; current = current.next ){
				sb.append(current.data.toString() + ", ");
			}
		
			return sb.toString();
		}
	}
	public String reverseToString(){
		//链表为空链表时
		if (empty()){
			return "[]";
		}
		else{
			StringBuilder sb = new StringBuilder();
			for (Node current = tail ; current != null; current = current.prev ){
				sb.append(current.data.toString() + ", ");
			}
			
			return sb.toString();
		}
	}
	public static void main(String[] args) {
		DubLink<String> list = new DubLink<String>();
		list.insert("aaaa" , 0);
		list.addTail("bbbb");
		list.insert("cccc" , 0);
		//在索引为1处插入一个新元素
		list.insert("dddd" , 1);
		list.insert("EEE", 4);
		//输出顺序线性表的元素
		System.out.println("原始元素："+list);
		//删除索引为2处的元素
		list.delete(2);
		System.out.println("删除索引为2的元素"+list);
		System.out.println("倒转显示："+list.reverseToString());
		//获取cccc字符串在顺序线性表中的位置
		System.out.println("cccc在顺序线性表中的位置：" 
			+ list.findElement("cccc"));
		System.out.println("链表中索引1处的元素：" 
			+ list.getNodeByIndex(1).data);
		list.remove();//删除链表最后一个元素
		System.out.println("调用remove方法后的链表:" + list);
		list.delete(0);//删除链表第一个元素
		System.out.println("调用delete(0)后的链表:" + list);
	}
}
