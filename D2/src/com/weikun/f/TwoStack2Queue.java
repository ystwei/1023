package com.weikun.f;



import java.util.Stack;

public class TwoStack2Queue {//2 to 4 for
	private Stack<Integer> spush;
	private Stack<Integer> spop;
	
	
	public TwoStack2Queue(){
		
		spush=new Stack<Integer>();
		spop=new Stack<Integer>();
	}
	public void add(int i){//���Ӹ���
		spush.add(i);
	}
	public int poll(){//ɾ����������ɾ������
		if(spush.isEmpty()&&spop.isEmpty()){
			System.out.println("�˶���Ϊ�գ�");
		}else{
			if(!spush.isEmpty()&&spop.isEmpty()){
				while(!spush.isEmpty()){
					spop.push(spush.pop());
				}
			}
		}
		return spop.pop();
	}
	public int peek(){//�鿴��������ɾ������
		if(spush.isEmpty()&&spop.isEmpty()){
			System.out.println("�˶���Ϊ�գ�");
		}else{
			if(!spush.isEmpty()&&spop.isEmpty()){
				while(!spush.isEmpty()){
					spop.push(spush.pop());
				}
			}
		}
		return spop.peek();
	}
	public static void main(String[] args) {
		TwoStack2Queue test = new TwoStack2Queue();
		test.add(1);
		test.add(2);
		test.add(3);
		System.out.println(test.peek());
		System.out.println(test.poll());
		System.out.println(test.peek());
		System.out.println(test.poll());
		System.out.println(test.peek());
		System.out.println(test.poll());
	}

}
