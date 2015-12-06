package com.weikun.f;










public class DubQueue <T>{
	public class Link<T> {//链结点  
		T data;     //数据域  
		Link<T> next; //后继指针，结点           链域  
		Link<T> previous; //前驱指针，结点       链域  
		Link(T data) {  
			this.data = data;  
		}  
		void displayLink() {  
			System.out.println("数据是： " + data.toString());  
		}  
	}  
	private Link<T> head;     //首结点  
	private Link<T> rear;     //尾部指针  

	public DubQueue() {  

	} 
	public T peekHead(){

		if(head!=null){
			return head.data;
		}
		return null;
	}
	public T peekRear() {  
		if (rear != null) {  
			return rear.data;  
		}  
		return null;  
	}  
	public boolean isEmpty() {  
		return head == null;  
	} 

	public void insertFirst(T data){//在head之前插入
		Link newnode=new Link(data);//新节点

		if(this.isEmpty()){
			rear=newnode;
		}else{
			head.previous=newnode;		
		}
		newnode.next=head;
		head=newnode;

	}
	public void insertLast(T data) {//在链尾 插入  		
		Link newnode=new Link(data);//新节点

		if(this.isEmpty()){
			head=newnode;
		}else{
			rear.next=newnode;		
		}
		newnode.previous=rear;
		rear=newnode;		
	}
	public T  deleteHead() {//删除 链头  
		if(this.isEmpty()){
			return null;
		}
		Link old=head;
		head=head.next;

		if(head==null){//因为删除的节点有可能是一个节点，删除完了就没有了，
			rear=null;
		}else{
			head.previous=null;
		}

		return (T)old.data;
	}

	public T  deleteRear() {//删除 链尾  
		if(this.isEmpty()){
			return null;
		}
		Link old=rear;
		rear=rear.previous;

		if(rear==null){//因为删除的节点有可能是一个节点，删除完了就没有了，
			head=null;
		}else{
			rear.next=null;
		}

		return (T)old.data;
	}
	public T find(T t) {//从头到尾find  

		if (isEmpty()) {  
			return null;  
		}  

		Link find=head;

		while(find!=null){
			if(!find.data.equals(t)){				

			}else{//找到了

				break;
			}

			find=find.next;
		}
		//没有找到数据，
		if(find==null){
			return null;
		}else{//找到数据
			return t;
		}

	}
	public T delete(T t){


		if (isEmpty()) {  
			return null;  
		}  

		Link find=head;

		while(find!=null){
			if(!find.data.equals(t)){				

			}else{//找到了

				break;
			}

			find=find.next;
		}
		if(find==null){
			return null;
		}
		if(find==head){
			head=head.next;
			if(head!=null){//多个节点
				head.previous=null;


			}
		}else if(find==rear){
			rear=rear.previous;
			if(rear!=null){//多个节点
				rear.next=null;
			}
		}else{//要找到的是中间节点

			find.next.previous=find.previous;
			find.previous.next=find.next;
		}
		return (T)find.data;
	}
	public boolean insertAfter(T key, T t) {//插入在key之后, key不存在return false  
		if (isEmpty()) {  
			return false;  
		} 
		Link find=head;

		while(find!=null){
			if(!find.data.equals(key)){				

			}else{//找到了

				break;
			}

			find=find.next;
		}
		Link<T> newLink = new Link<T>(t);  
		
		if(find==rear){
			rear=newLink;
			
		}else{//head mid			
			newLink.next=find.next;
			find.next.previous=newLink;
		}
		find.next = newLink;  
		newLink.previous = find;  
		return true;
	}
	public void displayList4Head() {//从头开始遍历  
		System.out.println("List (first-->last):");  
		Link<T> current = head;  
		while (current != null) {  
			current.displayLink();  
			current = current.next;  
		}  
	}  

	public void displayList4Rear() {//从尾开始遍历  
		System.out.println("List (last-->first):");  
		Link<T> current = rear;  
		while (current != null) {  
			current.displayLink();  
			current = current.previous;  
		}  
	}  
	public static void main(String[] args) {
		DubQueue<Integer> list = new DubQueue<Integer>();  
		list.insertLast(1);  
		list.insertFirst(2);  
		list.insertLast(3);  
		list.insertFirst(4);  
		list.insertLast(5);  
		list.displayList4Head();  


		Integer deleteHead = list.deleteHead();  
		System.out.println("deleteHead:" + deleteHead);  
		list.displayList4Head();  
//
		Integer deleteRear = list.deleteRear();  
		System.out.println("deleteRear:" + deleteRear);  
		list.displayList4Rear();  
//
	//	System.out.println("find:" + list.find(6));  
		System.out.println("find:" + list.find(3));  

		System.out.println("delete find:" + list.delete(6));  
		System.out.println("delete find:" + list.delete(1));  
		list.displayList4Head();  
//
		System.out.println("----在指定key后插入----");  
		list.insertAfter(2, 8);  
		list.insertAfter(2, 9);  
		list.insertAfter(9, 10);  
		list.displayList4Head();  
	}
	
}
