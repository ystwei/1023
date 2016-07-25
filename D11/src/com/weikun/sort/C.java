package com.weikun.sort;

public class C {//归并排序
	private static int[] data={50,10,90,30,70,40,80,60,20};
	public static void main(String[] args) {
		
		sort(data,0,data.length-1);
		
		for(int i:data){
			System.out.println(i);
		}
		
	}
	/**
	 * 
	 * @param data:要排序的数组
	 * @param left：左索引
	 * @param right：右索引
	 */
	public static void sort(int[] data ,int left ,int right){
		
		if(left<right){
			
			int center=(left+right)/2;//算出中间索引号
			//拆解左数组并排序
			sort(data,left,center);
//			/拆解右数组并排序
			sort(data,center+1,right);
			//
			merge(data,left,center,right);
		}
		
		
	}
	/**
	 * 
	 * @param data:待排序数组
	 * @param left：左索引
	 * @param center：1.左数组的最后一个索引，2.center+1右数组的第一个索引
	 * @param right:右索引
	 */
	public static void merge(int data[] ,int left,int center,int right){
		//1声明一个和待排数组长度一样的临时数组
		int[] tmp=new int[data.length];//合并用的
		int mid=center+1;//右数组的第一个索引
		int index=left;//操作临时数组的那个起始索引
		int i=left;
		
		while(left<=center&&mid<=right){
			
			if(data[left]-data[mid]<0){
				tmp[index++]=data[left++];
				
			}else{
				tmp[index++]=data[mid++];
				
			}
			
		}
		//左数组
		while(left<=center){
			
			tmp[index++]=data[left++];
		}
		//右数组
		while(mid<=right){
			
			tmp[index++]=data[mid++];
		}
		//把临时数组中已经排好的元素顺序送回到原始数组中。
		while(i<=right){
			
			data[i]=tmp[i++];
		}
	}
}
