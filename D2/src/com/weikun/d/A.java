package com.weikun.d;

public  class A {//�ڲ��� inner class/ nested class
	//���Ա��static block  block{} properties method constructor inner class
	class A1{
		{
			
		}
		A1(){
			
		}
		private int age=100;
		public void go(String city){
			System.out.println(city);
		}
	}
	public void plan(){
		new A1().go("����");
	}
}
class A0{
	
}