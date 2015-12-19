package com.weikun.Thread;

public class DrawMoney extends Thread {
	
	private String name;
	private Account account;
	private int money;
	public DrawMoney(String name,Account account,int money){
		this.name=name;
		this.account=account;
		this.money=money;
		
		
	}
	@Override
	public void run() {//正宗取钱
		// TODO Auto-generated method stub
		synchronized (account) {
			if(account.getBalance()>=this.money){// 如果大于，证明可以取钱了
				try{
					Thread.sleep(1);			
				}catch (InterruptedException ex){
					ex.printStackTrace();
				}
				account.setBalance(account.getBalance()-this.money);
				System.out.println(this.name+"已经取了："+this.money);
			}else{
				System.out.println(this.name+"没有"+this.money+"元了！，不能取了！");
			}
			
		}
		
		
	}
}
