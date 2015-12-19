package com.weikun.Thread2;



public class Test {
	public static void main(String[] args) {
		//创建一个账户
		Account acct = new Account("1234567" , 0);
		new GetMoney("取钱者" , acct , 800).start();
		new SaveMoney("存款者甲" , acct , 800).start();
		new SaveMoney("存款者乙" , acct , 800).start();
		new SaveMoney("存款者丙" , acct , 800).start();
	}
}
