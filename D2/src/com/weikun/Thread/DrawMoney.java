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
	public void run() {//����ȡǮ
		// TODO Auto-generated method stub
		synchronized (account) {
			if(account.getBalance()>=this.money){// ������ڣ�֤������ȡǮ��
				try{
					Thread.sleep(1);			
				}catch (InterruptedException ex){
					ex.printStackTrace();
				}
				account.setBalance(account.getBalance()-this.money);
				System.out.println(this.name+"�Ѿ�ȡ�ˣ�"+this.money);
			}else{
				System.out.println(this.name+"û��"+this.money+"Ԫ�ˣ�������ȡ�ˣ�");
			}
			
		}
		
		
	}
}
