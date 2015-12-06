package com.weikun.f;










public class DubQueue <T>{
	public class Link<T> {//�����  
		T data;     //������  
		Link<T> next; //���ָ�룬���           ����  
		Link<T> previous; //ǰ��ָ�룬���       ����  
		Link(T data) {  
			this.data = data;  
		}  
		void displayLink() {  
			System.out.println("�����ǣ� " + data.toString());  
		}  
	}  
	private Link<T> head;     //�׽��  
	private Link<T> rear;     //β��ָ��  

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

	public void insertFirst(T data){//��head֮ǰ����
		Link newnode=new Link(data);//�½ڵ�

		if(this.isEmpty()){
			rear=newnode;
		}else{
			head.previous=newnode;		
		}
		newnode.next=head;
		head=newnode;

	}
	public void insertLast(T data) {//����β ����  		
		Link newnode=new Link(data);//�½ڵ�

		if(this.isEmpty()){
			head=newnode;
		}else{
			rear.next=newnode;		
		}
		newnode.previous=rear;
		rear=newnode;		
	}
	public T  deleteHead() {//ɾ�� ��ͷ  
		if(this.isEmpty()){
			return null;
		}
		Link old=head;
		head=head.next;

		if(head==null){//��Ϊɾ���Ľڵ��п�����һ���ڵ㣬ɾ�����˾�û���ˣ�
			rear=null;
		}else{
			head.previous=null;
		}

		return (T)old.data;
	}

	public T  deleteRear() {//ɾ�� ��β  
		if(this.isEmpty()){
			return null;
		}
		Link old=rear;
		rear=rear.previous;

		if(rear==null){//��Ϊɾ���Ľڵ��п�����һ���ڵ㣬ɾ�����˾�û���ˣ�
			head=null;
		}else{
			rear.next=null;
		}

		return (T)old.data;
	}
	public T find(T t) {//��ͷ��βfind  

		if (isEmpty()) {  
			return null;  
		}  

		Link find=head;

		while(find!=null){
			if(!find.data.equals(t)){				

			}else{//�ҵ���

				break;
			}

			find=find.next;
		}
		//û���ҵ����ݣ�
		if(find==null){
			return null;
		}else{//�ҵ�����
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

			}else{//�ҵ���

				break;
			}

			find=find.next;
		}
		if(find==null){
			return null;
		}
		if(find==head){
			head=head.next;
			if(head!=null){//����ڵ�
				head.previous=null;


			}
		}else if(find==rear){
			rear=rear.previous;
			if(rear!=null){//����ڵ�
				rear.next=null;
			}
		}else{//Ҫ�ҵ������м�ڵ�

			find.next.previous=find.previous;
			find.previous.next=find.next;
		}
		return (T)find.data;
	}
	public boolean insertAfter(T key, T t) {//������key֮��, key������return false  
		if (isEmpty()) {  
			return false;  
		} 
		Link find=head;

		while(find!=null){
			if(!find.data.equals(key)){				

			}else{//�ҵ���

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
	public void displayList4Head() {//��ͷ��ʼ����  
		System.out.println("List (first-->last):");  
		Link<T> current = head;  
		while (current != null) {  
			current.displayLink();  
			current = current.next;  
		}  
	}  

	public void displayList4Rear() {//��β��ʼ����  
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
		System.out.println("----��ָ��key�����----");  
		list.insertAfter(2, 8);  
		list.insertAfter(2, 9);  
		list.insertAfter(9, 10);  
		list.displayList4Head();  
	}
	
}
