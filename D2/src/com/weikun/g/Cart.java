package com.weikun.g;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	//车
	private List<Goods> list=new ArrayList<Goods>();
	public List<Goods> buy(Goods newGood){
		boolean flag=false;
		for(int i=0;i<list.size();i++){
			Goods oldGood=list.get(i);//老商品
			if(newGood.getNo().equals(oldGood.getNo())){
				//在相同商品编号时，改变老商品的数量
				oldGood.setQuantity(oldGood.getQuantity()+newGood.getQuantity());
				flag=true;
				break;
			}
			
		}
		
		if(flag==false){
			list.add(newGood);
		}
		return list;
		
	}
}
