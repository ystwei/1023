package com.xijinping;

public class D {
	
	public void ok(){
		int old=12;
		if(old<18){			
			try {
				throw new MyException1(old);
			} catch (MyException1 e) {
				// TODO Auto-generated catch block
				System.out.println(e);//toString				//
			}
		}else if(old>80){
			System.out.println("�����˽���");
		}else{
			
			System.out.println("�������");
		}
	}
	public static void main(String[] args) {
		new D().ok();
	}
}
class MyException1 extends Exception{
	private int old;
	public MyException1(int old){
		this.old=old;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.old+"��δ�����˽���";
	}
	
}
class MyException2 extends Exception{
	
	
}