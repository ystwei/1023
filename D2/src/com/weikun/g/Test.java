package com.weikun.g;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart c=new Cart();
		//public Goods(String name, double price, int quantity, String no) {
		c.buy(new Goods("ţ��",18,2,"0001"));
		c.buy(new Goods("ţ��",18,3,"0001"));
		c.buy(new Goods("��ţ",180,20,"0002"));
		List<Goods> list=c.buy(new Goods("�ɿ���",20,10,"0003"));
		double sum=0;
		for(Goods g :list){
			sum+=g.getPrice()*+g.getQuantity();
			System.out.println("������ǣ�"+g.getName()+"�۸���"+g.getPrice()+";�����ǣ�"+g.getQuantity());
		}
		System.out.println("����Ҫ֧���ܼƣ�"+sum+"�����");
		
	}

}
