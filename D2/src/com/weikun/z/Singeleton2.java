package com.weikun.z;
//����ģʽ�ĵ����֣���̬�ڲ���ʵ��
public class Singeleton2 {
	private static class Singleholder{
		private static final Singeleton2 s=new Singeleton2();
	}
	public static  Singeleton2 getInstance(){
		return Singleholder.s;
	}
	private Singeleton2(){
		
	}
	
}
