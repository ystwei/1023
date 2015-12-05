package com.weikun.f;

public class MyStack implements IMyStack {//数组实现栈
	private Object [] os=new Object[2];
	private int size=0;//栈的长度
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for(int i=0;i<size;i++){
			os[i]=null;
		}
		size=0;
	}
	public void resize(){
		Object [] temp=new Object[size*2];
		
		for(int i=0;i<size;i++){
			temp[i]=os[i];
			os[i]=null;
			
		}
		os=temp;
	}
	@Override
	public int length() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean push(Object data) {
		// TODO Auto-generated method stub
		
		if(size>=os.length){
			this.resize();
		}
		os[size++]=data;
		return true;
	}

	@Override
	public Object pop() {//弹出栈顶
		// TODO Auto-generated method stub
		Object old=os[size-1];
		
		os[--size]=null;
		
		return old;
	}

	@Override
	public Object peek() {//查看栈顶
		// TODO Auto-generated method stub
		return os[size-1];
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<size;i++){
			
			
			sb.append(os[i]);
			sb.append(",");
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		MyStack m=new MyStack();
		
		m.push(100);
		m.push(200);
		m.push(300);
		System.out.println(m);
//		System.out.println(m.pop());
//		System.out.println(m.pop());
	}
}
