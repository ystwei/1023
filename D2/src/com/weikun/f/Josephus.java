package com.weikun.f;
public class Josephus {
	//定义结点，
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
		int n = 17;//定义总人数n
		int m = 3;//和出圈数字m  
		//初始化循环列表,头结点first和尾结点last  		
		Node first = new Node(0);  
		first.next = first;  //一个节点的时候，头就是尾，尾就是头
		Node last = first;  
		for(int i=1; i<n; i++){//形成循环链表  
			Node temp = new Node(i);  
			temp.next = last;  
			last.next = temp;  
			last = last.next;  
		}  
		last.next = first;//最终让其首尾相连，形成循环链表 ，尾接头形成循环链表（last为尾结点）  
		//执行出圈操作  
		System.out.println("出圈顺序为:");  
		while(last != last.next){  
			//下面for循环后，last是第m个结点的前一个结点  
			for(int i=1; i<m; i++){  //遍历要删除节点 前一个出圈数字 
				last = last.next;  
			}
			//出循环之后，就是要删除的节点，删除第m个结点  
			System.out.print(last.next.data+" "); //出圈的数字

			last.next = last.next.next;  //指向要删除的节点的下一节点
		}  
		System.out.print("\n幸运者是:"+last.data);//原来是10号
	}

}

