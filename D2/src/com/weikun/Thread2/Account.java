package com.weikun.Thread2;

public class Account {
	private String accountNo;
	private double balance;
	private boolean flag=false;//false:ûǮ�����Դ��ˣ�true:��Ǯ������ȡ��

	public Account(String accountNo,double balance){
		this.accountNo=accountNo;
		this.balance=balance;

	}

	//ȡ��
	public  void getMoney(double money){
		synchronized(this){
			if(flag==false){//ȡ��ĵ�ǰ�̵߳Ⱥ򣬵ȴ�notify
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{//flag==true����Ǯ�ˣ�����ȡ����


				this.balance-=money;
				System.out.println("���Ѿ�ȡ�ˣ�"+money+"Ԫ��");
				flag=false;
				this.notifyAll();


			}
		}
	}
	//���
	public  void saveMoney(double money){
		synchronized(this){
			if(flag==true){//����ȡ�ˣ�
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}else{//���Դ���
				this.balance+=money;
				System.out.println("���Ѿ����ˣ�"+money+"Ԫ��");
				flag=true;
				notifyAll();
			}
		}
	}
}
