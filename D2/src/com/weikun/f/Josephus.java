package com.weikun.f;
public class Josephus {
	//�����㣬
	class Node{  
		int data;  
		Node next;  
		Node(int arg1){  
			this.data = arg1;  
		}  
	}  
	public static void main(String[] args){  
		new Josephus().yuekill();  
	}  
	public void yuekill(){
		int n = 17;//����������n
		int m = 3;//�ͳ�Ȧ����m  
		//��ʼ��ѭ���б�,ͷ���first��β���last  		
		Node first = new Node(0);  
		first.next = first;  //һ���ڵ��ʱ��ͷ����β��β����ͷ
		Node last = first;  
		for(int i=1; i<n; i++){//�γ�ѭ������  
			Node temp = new Node(i);  
			temp.next = last;  
			last.next = temp;  
			last = last.next;  
		}  
		last.next = first;//����������β�������γ�ѭ������ ��β��ͷ�γ�ѭ������lastΪβ��㣩  
		//ִ�г�Ȧ����  
		System.out.println("��Ȧ˳��Ϊ:");  
		while(last != last.next){  
			//����forѭ����last�ǵ�m������ǰһ�����  
			for(int i=1; i<m; i++){  //����Ҫɾ���ڵ� ǰһ����Ȧ���� 
				last = last.next;  
			}
			//��ѭ��֮�󣬾���Ҫɾ���Ľڵ㣬ɾ����m�����  
			System.out.print(last.next.data+" "); //��Ȧ������

			last.next = last.next.next;  //ָ��Ҫɾ���Ľڵ����һ�ڵ�
		}  
		System.out.print("\n��������:"+last.data);//ԭ����10��
	}

}

