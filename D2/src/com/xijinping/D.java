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
			System.out.println("老年人禁看");
		}else{
			
			System.out.println("尽情观赏");
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
		return this.old+"岁未成年人禁看";
	}
	
}
class MyException2 extends Exception{
	
	
}