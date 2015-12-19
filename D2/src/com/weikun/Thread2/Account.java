package com.weikun.Thread2;

public class Account {
	private String accountNo;
	private double balance;
	private boolean flag=false;//false:没钱，可以存了，true:有钱，可以取了

	public Account(String accountNo,double balance){
		this.accountNo=accountNo;
		this.balance=balance;

	}

	//取款
	public  void getMoney(double money){
		synchronized(this){
			if(flag==false){//取款的当前线程等候，等待notify
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{//flag==true，有钱了，可以取款了


				this.balance-=money;
				System.out.println("你已经取了，"+money+"元！");
				flag=false;
				this.notifyAll();


			}
		}
	}
	//存款
	public  void saveMoney(double money){
		synchronized(this){
			if(flag==true){//可以取了，
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}else{//可以存了
				this.balance+=money;
				System.out.println("你已经存了，"+money+"元！");
				flag=true;
				notifyAll();
			}
		}
	}
}
