package com.xijinping;

public class E {
	public static void main(String[] args) {
		int i=200;
		assert i==100:"断言100失败，此表达式的信息将会在抛出异常的时候输出！";
        System.out.println("断言1没有问题，Go！");
 
        System.out.println("\n-----------------\n");
 
        //断言2结果为false,程序终止
        assert i==200 : "断言失败，此表达式的信息将会在抛出异常的时候输出！";
        System.out.println("断言2没有问题，Go！");
	}
}
