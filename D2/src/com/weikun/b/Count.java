package com.weikun.b;

/**
 * 静态块演示
 */


/**
 * @author Owner
 *
 */
public class Count {
	private int serialNumber;
	public static int counter;
	//自由块 
	{
		System.out.println("自由块被执行");//2
		counter = 2;
	}
	//静态自由块
	static {
		System.out.println("static自由块被执行");
		counter ++;
	}
	public static int getTotalCount() {
		return counter;
	}	
	public Count() {
		counter++;
		serialNumber = counter;
	}
	public static void main(String[] args){
		System.out.println("main() invoked");//0
   // Count co=new Count();    //第一种方式，也可以采用静态调用的方式      
		System.out.println("counter = "+Count.counter); 
	//	Count co1=new Count();  
		System.out.println("counter = "+ ++Count.counter); 
	}
}
