package com.weikun.d;

public class M {
	public static void main(String[] args) {
		System.out.printf("%+-4.2f",123f);
		System.out.println();
		System.out.printf("%+-6.2f",45f);
		System.out.println();
		System.out.printf("%o",45);
		
		System.out.println();
		System.out.printf("%#x",65535);
		
		
		System.out.println();
		System.out.printf("%s","中国");
		
		System.out.println();
		System.out.printf("我是字符串%4s,我是整数%d","中国",89);
		System.out.println();
		System.out.printf("我是%2$s,我爱%1$s","中国",89);
	}
}
