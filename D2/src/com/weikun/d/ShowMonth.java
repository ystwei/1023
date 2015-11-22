package com.weikun.d;


import java.util.Calendar;
import java.text.*;
import java.util.Date;
public class ShowMonth {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();// 获取一个Calendar对象
		int count = 0;// 定义一个计数变量
		//得到当前年
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		
		int year = Integer.parseInt(sdf.format(new Date()));
		sdf=new SimpleDateFormat("MM"); 
		int month = Integer.parseInt(sdf.format(new Date()))-1;//老外是以0作为第一个月
		
		calendar.set(Calendar.YEAR, year);// 设置年份
		calendar.set(Calendar.MONTH, month);// 设置月份
		calendar.set(Calendar.DATE, 0);// 设置日期
		int days = chooseMonth(month + 1);
		System.out.println(year + " 年 " + (month + 1) + " 月 的 日 历 如 下：");
		System.out.println("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");
		while (count < days) {
			calendar.add(Calendar.DAY_OF_MONTH, 1);// 设置添加日历的周期为1
			int day = calendar.getTime().getDay();// 获取日历的星期几表示数，例如：0：表示星期日
			if (count == 0) {// 根据星期几来决定输入几个tab
				for (int i = 0; i < day; i++) {
					System.out.print("\t");
				}
			}
			if (day == 0) {// 如果是周日了则换行
				System.out.println();
			}
			
			int d=calendar.getTime().getDate();
			SimpleDateFormat si=new SimpleDateFormat("dd");
			String s=si.format(new Date());
			
			if(d==new Integer(s)){
				System.out.print(calendar.getTime().getDate() +"*"+ "\t");// 获取日历中日期数
				
			}else{
				
				System.out.print(calendar.getTime().getDate() + "\t");// 获取日历中日期数
			}
			//System.out.print(calendar.getTime().getDate() + "\t");// 获取日历中日期数
			count++;
		}
	}
	public static int chooseMonth(int m) {// 根据月份选择天数
		int days = 0;
		switch (m) {
		case 2:
			days = 28;
			break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		default:
			days = 0;
		}
		return days;
	}
}

