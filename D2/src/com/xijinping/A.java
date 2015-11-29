package com.xijinping;

import java.io.IOException;
import java.util.Date;

public class A {
	public static void main(String[] args) {
		//System.out.println(Integer.parseInt(args[0])/0);
		try {
			Date d=null;
			d.setYear(100);
			System.out.println(1/0);			
		}catch(Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
			String s=e.getMessage();
			if(s.equals("/ by zero")){
				System.out.println("除零了");//一旦出现错误，打印栈的轨迹
			}
			
		}finally{
			System.out.println("ok");		
			
		}
	}
}
