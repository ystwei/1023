package com.weikun.d;

public class G {
	public static void main(String[] args) {
		//ǰ׺ prefix
		//��׺ suffix
		//System.out.println("1.mp3".startsWith("1.m"));
		
		
		//System.out.println("1.mp3".endsWith("13"));
		
//		/System.out.println("ABCDEF".indexOf("DE",-2));
		System.out.println("ABCDEDEDEF".lastIndexOf("DE",8));
		
		System.out.println(" B C ".trim());
		
		String a="b$������$������";
		
		String s[]=a.split("\\$");//$^
		
		for(String b :s){//
			System.out.println(b);
		}
	}
}
