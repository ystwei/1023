package com.weikun.sort;

import java.util.Arrays;



public class D {//ֱ�Ӳ�������

	
	
	public static void main(String[] args) {
		int[] nums = {49,38,10,97,76,13,27}; 		
		
		sort(nums);
		
		for(int i :nums){
			System.out.println(i);
		}
		
	}
	public static void sort(int [] data){
		
		
		for(int i=1;i<data.length;i++){
			int index=-1;
			for(int j=0;j<i;j++){
				
				if(data[j]-data[i]>0){//ǰ����ں���
					
					index=j;
					break;
				}
			}
			
			//Ҫ�����˸����
			if(index!=-1){
				moveBack( index,i , data);
			}
			
			
		}
		
	}
	public static void moveBack(int from ,int to ,int [] data){
		int tmp=0;
		
		for(int i=to;i>from ;i--){
			tmp=data[i];
			data[i]=data[i-1];
			data[i-1]=tmp;
		}
		
		
		
	}
}
