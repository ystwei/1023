package com.weikun.sort;

public class E {//Shell排序
	
	
	public static int count = 0;
	private static int [] data={47,55,10,40,15,94,5,70};
	
	public static void main(String[] args) {
		//1计算其增量 h
		int arraylength=data.length;
		int h=0;//增量初始值
		
		
		while(h<=arraylength/3){
			
			h=h*3+1;
		}
		
		while(h>0){
			for(int i=h;i<arraylength;i++){
				int tmp=data[i];//先把一段的后面的值存储在临时变量中
				
				if(data[i-h]>data[i]){//如果一段的前面的值大于后面的值
					//两个值互相退格对调
					int j=i-h;
					
					for(;j>=0&&data[j]-tmp>0;j=j-h){
						
						data[j+h]=data[j];
					}
					data[j+h]=tmp;
				}
				
			}
			
			h=(h-1)/3;
		}
		
		
		for(int i :data){
			System.out.println(i);
			
		}
	}

}
