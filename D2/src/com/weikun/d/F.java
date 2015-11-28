package com.weikun.d;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class F {
	public static void main(String[] args) {
		String s0="beijing";
		String s="beijing";
		
		String s1="weikun"+"is pretty";
		String s2="weikun".concat("is good");
		String s3=new String("beijing");//强制重新开辟堆
		System.out.println(s0==s);
		System.out.println(s0.equals(s3));
		
		String s4=String.valueOf(1.9);
		
		try {
			String a=new String("你好".getBytes("ISO8859-1"),"utf-8");
			
			System.out.println(a);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
