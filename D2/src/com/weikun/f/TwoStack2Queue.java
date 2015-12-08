package com.weikun.f;



import java.util.Stack;

public class TwoStack2Queue {//2 to 4 for
	private Stack<Integer> spush;
	private Stack<Integer> spop;
	
	
	public TwoStack2Queue(){
		
		spush=new Stack<Integer>();
		spop=new Stack<Integer>();
	}
	public void add(int i){//增加个数
		spush.add(i);
	}
	public int poll(){//删除，并返回删除的数
		if(spush.isEmpty()&&spop.isEmpty()){
			System.out.println("此队列为空！");
		}else{
			if(!spush.isEmpty()&&spop.isEmpty()){
				while(!spush.isEmpty()){
					spop.push(spush.pop());
				}
			}
		}
		return spop.pop();
	}
	public int peek(){//查看，并返回删除的数
		if(spush.isEmpty()&&spop.isEmpty()){
			System.out.println("此队列为空！");
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
