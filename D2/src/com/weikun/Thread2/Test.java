package com.weikun.Thread2;



public class Test {
	public static void main(String[] args) {
		//����һ���˻�
		Account acct = new Account("1234567" , 0);
		new GetMoney("ȡǮ��" , acct , 800).start();
		new SaveMoney("����߼�" , acct , 800).start();
		new SaveMoney("�������" , acct , 800).start();
		new SaveMoney("����߱�" , acct , 800).start();
	}
}
