package com.weikun.Thread;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account a=new Account("NO1234567",800);
		DrawMoney dm=new DrawMoney("��",a,800);
		dm.start();
		
		DrawMoney dm1=new DrawMoney("��",a,800);
		dm1.start();
		
	}

}
