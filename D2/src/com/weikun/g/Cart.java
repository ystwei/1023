package com.weikun.g;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	//��
	private List<Goods> list=new ArrayList<Goods>();
	public List<Goods> buy(Goods newGood){
		boolean flag=false;
		for(int i=0;i<list.size();i++){
			Goods oldGood=list.get(i);//����Ʒ
			if(newGood.getNo().equals(oldGood.getNo())){
				//����ͬ��Ʒ���ʱ���ı�����Ʒ������
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
