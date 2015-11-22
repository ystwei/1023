package com.weikun.d;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class D {
	public static void main(String[] args) {
		go();
		
		
		
	}
	private static void go(){
		Calendar c=Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
		System.out.print(c.get(Calendar.YEAR)+"-");
		System.out.print(c.get(Calendar.MONTH)+1);
		System.out.print(c.get(Calendar.DAY_OF_MONTH));
		System.out.print(c.get(Calendar.HOUR_OF_DAY));
		System.out.print(c.get(Calendar.MINUTE));
	}
	/**
	 * 
	 */
	private static void ok() {
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss D w W E");
		
		System.out.println(sdf.format(new Date()));
	}
}
