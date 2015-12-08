package com.weikun.f;







public class SingleLink<T> {
	private class Node{
		//����ڵ������
		private T data;
		//ָ���¸��ڵ������
		private Node next;

		//��ʼ��ȫ�����ԵĹ�����
		public Node(T data , Node next)	{
			this.data = data;//��ǰ�ڵ������
			this.next = next;//��ǰ�ڵ����һ�ڵ�
		}

	}
	//����������ͷ�ڵ�
	private Node header;
	//����������β�ڵ�
	private Node tail;
	//������������Ѱ����Ľڵ���
	private int size;
	//����������
	public SingleLink() {
		// TODO Auto-generated constructor stub
		header=null;
		tail=null;
	}
	//��������ĳ���	
	public int length(){
		return size;
	}
	public Node getNodeByIndex(int index){//���������ţ��ҵ��ڵ�
		if(index<0||index>size-1){
			System.out.println("���ǲ�����ģ���ɵ��");
			return null;//��������ԭ��

		}
		Node cur=header;
		for(int i=0;i<size;i++){
			if(cur==null){
				break;//û�ҵ���
			}

			if(i==index){//�ҵ���
				return cur;
			}

			cur=cur.next;//������ǰ��

		}
		return null;
	}
	//����Ԫ���ҵ�������
	public int findElement(T element){

		Node cur=header;
		for(int i=0;i<size;i++){
			if(cur==null){
				break;//û�ҵ���
			}

			if(cur.data.equals(element)){//�ҵ���
				return i;
			}			
			cur=cur.next;//������ǰ��			
		}
		return -1;
	}
	public void addTail(T element){		
		if(header==null){			
			header=new Node(element,null);			
			this.tail=header;
		}else{//��ǰ���нڵ�			
			Node nnode=new Node(element,null);//���������ӵ�β
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
			System.out.println("���ǲ�����ģ���ɵ��");
			return ;//��������ԭ��

		}
		if(header==null){
			this.addTail(element);
		}else{
			if(index==0){
				this.addHeader(element);
			}else{

				// �ҵ�Ҫ���������ŵ�ǰһ�ڵ�
				Node prev=this.getNodeByIndex(index-1);
				prev.next=new Node(element,prev.next);

			}

		}
		size++;


	}
	public T del(int index){
		if(index<0||index-size>0){
			System.out.println("���ǲ�����ģ���ɵ��");
			return null;//��������ԭ��

		}
		Node del=null;
		if(index==0){
			header=header.next;
		}else{
			Node prev=this.getNodeByIndex(index-1);//�ҵ�Ҫɾ�����ǰһ�ڵ�
			del=prev.next;
			prev.next=del.next;
			del.next=null;

		}
		size--;
		return del.data;
	}
	//�ж���ʽ���Ա��Ƿ�Ϊ�ձ�
	public boolean empty(){
		return size == 0;
	}
	//������Ա�
	public void clear(){
		//header��tail��Ϊnull
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
		System.out.println("ԭʼ������"+list);
		
		
		//������Ϊ1������һ����Ԫ��
		list.insert("dddd" , 1);
		//���˳�����Ա��Ԫ��
		System.out.println("����֮�������"+list);
		//ɾ������Ϊ2����Ԫ��
		list.del(2);
		System.out.println("ɾ��֮�������"+list);
		//��ȡcccc�ַ����������е�λ��
		System.out.println("cccc�������е�λ�ã�" 
			+ list.findElement("cccc"));
		System.out.println("����������2����Ԫ�أ�" 
			+ list.getNodeByIndex(2));
	}
}
