package com.weikun.g;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart c=new Cart();
		//public Goods(String name, double price, int quantity, String no) {
		c.buy(new Goods("牛奶",18,2,"0001"));
		c.buy(new Goods("牛奶",18,3,"0001"));
		c.buy(new Goods("奶牛",180,20,"0002"));
		List<Goods> list=c.buy(new Goods("巧克力",20,10,"0003"));
		double sum=0;
		for(Goods g :list){
			sum+=g.getPrice()*+g.getQuantity();
			System.out.println("你买的是："+g.getName()+"价格是"+g.getPrice()+";数量是："+g.getQuantity());
		}
		System.out.println("你需要支付总计："+sum+"人民币");
		
	}

}
