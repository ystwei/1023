package com.weikun.d;

public  class A {//内部类 inner class/ nested class
	//类成员：static block  block{} properties method constructor inner class
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
		new A1().go("北京");
	}
}
class A0{
	
}