package com.weikun.b;

/**
 * ��̬����ʾ
 */


/**
 * @author Owner
 *
 */
public class Count {
	private int serialNumber;
	public static int counter;
	//���ɿ� 
	{
		System.out.println("���ɿ鱻ִ��");//2
		counter = 2;
	}
	//��̬���ɿ�
	static {
		System.out.println("static���ɿ鱻ִ��");
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
   // Count co=new Count();    //��һ�ַ�ʽ��Ҳ���Բ��þ�̬���õķ�ʽ      
		System.out.println("counter = "+Count.counter); 
	//	Count co1=new Count();  
		System.out.println("counter = "+ ++Count.counter); 
	}
}
