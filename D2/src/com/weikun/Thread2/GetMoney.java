package com.weikun.Thread2;



public class GetMoney extends Thread{
	//ģ���û��˻�
		private Account account;
		//��ǰȡǮ�߳���ϣ��ȡ��Ǯ��
		private double drawAmount;

		public GetMoney(String name , Account account , 
			double drawAmount){
			super(name);
			this.account = account;
			this.drawAmount = drawAmount;
		}

		//�ظ�100��ִ��ȡǮ����
		public void run(){
			for (int i = 0 ; i < 100 ; i++ ){
				account.getMoney(drawAmount);
			}
		}
}
