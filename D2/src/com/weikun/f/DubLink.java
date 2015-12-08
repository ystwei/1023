package com.weikun.f;









public class DubLink<T> {
	//����һ���ڲ���Node��Nodeʵ����������Ľڵ㡣
	private class Node{
		//����ڵ������
		private T data;
		//ָ���ϸ��ڵ������
		private Node prev;
		//ָ���¸��ڵ������
		private Node next;

		//��ʼ��ȫ�����ԵĹ�����
		public Node(T data , Node prev , Node next){
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}
	//����������ͷ�ڵ�
	private Node header;
	//����������β�ڵ�
	private Node tail;
	//������������Ѱ����Ľڵ���
	private int size;
	//����������
	public DubLink(){
		//������header��tail����null
		header = null;
		tail = null;
	}
	//��������ĳ���	
	public int length(){
		return size;
	}
	public Node getNodeByIndex(int index){
		if (index < 0 || index > size - 1){
			System.out.println("����ʦ��ʾ�����Ա�����Խ��");
			return null;
		}

		if(index<=size/2){//��ͷ����
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
	//������ʽ���Ա���ָ��Ԫ�ص�����
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
			System.out.println("����ʦ��ʾ�����Ա�����Խ��");
		}else{
			if(header==null){
				this.addHeader(element);
			}else{
				if(index==0){
					this.addHeader(element);
				}else{
					
					//�ҵ������ŵ�ǰһ������ָ���Ľڵ�
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
			System.out.println("���Ա�����Խ��");
		}
		if(index==0){//ɾ��ͷ��
			
			
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
	//ɾ����ʽ���Ա������һ��Ԫ��
    public T remove(){
		return delete(size - 1);
	}
	//�ж���ʽ���Ա��Ƿ�Ϊ������
	public boolean empty(){
		return size == 0;
	}
	//������Ա�
	public void clear(){
		//���ײ���������Ԫ�ظ�Ϊnull
		header = null;
		tail = null;
		size = 0;
	}
	
	//����β�巨Ϊ��������½ڵ㡣
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
	//����ͷ�巨Ϊ��������½ڵ㡣
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
		//����Ϊ������ʱ
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
		//����Ϊ������ʱ
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
		//������Ϊ1������һ����Ԫ��
		list.insert("dddd" , 1);
		list.insert("EEE", 4);
		//���˳�����Ա��Ԫ��
		System.out.println("ԭʼԪ�أ�"+list);
		//ɾ������Ϊ2����Ԫ��
		list.delete(2);
		System.out.println("ɾ������Ϊ2��Ԫ��"+list);
		System.out.println("��ת��ʾ��"+list.reverseToString());
		//��ȡcccc�ַ�����˳�����Ա��е�λ��
		System.out.println("cccc��˳�����Ա��е�λ�ã�" 
			+ list.findElement("cccc"));
		System.out.println("����������1����Ԫ�أ�" 
			+ list.getNodeByIndex(1).data);
		list.remove();//ɾ���������һ��Ԫ��
		System.out.println("����remove�����������:" + list);
		list.delete(0);//ɾ�������һ��Ԫ��
		System.out.println("����delete(0)�������:" + list);
	}
}
