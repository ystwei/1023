package com.weikun.d;


import java.util.Calendar;
import java.text.*;
import java.util.Date;
public class ShowMonth {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();// ��ȡһ��Calendar����
		int count = 0;// ����һ����������
		//�õ���ǰ��
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		
		int year = Integer.parseInt(sdf.format(new Date()));
		sdf=new SimpleDateFormat("MM"); 
		int month = Integer.parseInt(sdf.format(new Date()))-1;//��������0��Ϊ��һ����
		
		calendar.set(Calendar.YEAR, year);// �������
		calendar.set(Calendar.MONTH, month);// �����·�
		calendar.set(Calendar.DATE, 0);// ��������
		int days = chooseMonth(month + 1);
		System.out.println(year + " �� " + (month + 1) + " �� �� �� �� �� �£�");
		System.out.println("������\t����һ\t���ڶ�\t������\t������\t������\t������");
		while (count < days) {
			calendar.add(Calendar.DAY_OF_MONTH, 1);// �����������������Ϊ1
			int day = calendar.getTime().getDay();// ��ȡ���������ڼ���ʾ�������磺0����ʾ������
			if (count == 0) {// �������ڼ����������뼸��tab
				for (int i = 0; i < day; i++) {
					System.out.print("\t");
				}
			}
			if (day == 0) {// ���������������
				System.out.println();
			}
			
			int d=calendar.getTime().getDate();
			SimpleDateFormat si=new SimpleDateFormat("dd");
			String s=si.format(new Date());
			
			if(d==new Integer(s)){
				System.out.print(calendar.getTime().getDate() +"*"+ "\t");// ��ȡ������������
				
			}else{
				
				System.out.print(calendar.getTime().getDate() + "\t");// ��ȡ������������
			}
			//System.out.print(calendar.getTime().getDate() + "\t");// ��ȡ������������
			count++;
		}
	}
	public static int chooseMonth(int m) {// �����·�ѡ������
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

