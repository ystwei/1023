package com.weikun.Thread2;



public class SaveMoney extends Thread{
	//模拟用户账户
	private Account account;
	//当前取钱线程所希望存款的钱数
	private double depositAmount;

	public SaveMoney(String name , Account account , 
			double depositAmount){
		super(name);
		this.account = account;
		this.depositAmount = depositAmount;
	}

	//重复100次执行存款操作
	public void run(){
		for (int i = 0 ; i < 100 ; i++ ){
			account.saveMoney(depositAmount);
		}		
	}
}
