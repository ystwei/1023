package com.weikun.sort;

public class C {//�鲢����
	private static int[] data={50,10,90,30,70,40,80,60,20};
	public static void main(String[] args) {
		
		sort(data,0,data.length-1);
		
		for(int i:data){
			System.out.println(i);
		}
		
	}
	/**
	 * 
	 * @param data:Ҫ���������
	 * @param left��������
	 * @param right��������
	 */
	public static void sort(int[] data ,int left ,int right){
		
		if(left<right){
			
			int center=(left+right)/2;//����м�������
			//��������鲢����
			sort(data,left,center);
//			/��������鲢����
			sort(data,center+1,right);
			//
			merge(data,left,center,right);
		}
		
		
	}
	/**
	 * 
	 * @param data:����������
	 * @param left��������
	 * @param center��1.����������һ��������2.center+1������ĵ�һ������
	 * @param right:������
	 */
	public static void merge(int data[] ,int left,int center,int right){
		//1����һ���ʹ������鳤��һ������ʱ����
		int[] tmp=new int[data.length];//�ϲ��õ�
		int mid=center+1;//������ĵ�һ������
		int index=left;//������ʱ������Ǹ���ʼ����
		int i=left;
		
		while(left<=center&&mid<=right){
			
			if(data[left]-data[mid]<0){
				tmp[index++]=data[left++];
				
			}else{
				tmp[index++]=data[mid++];
				
			}
			
		}
		//������
		while(left<=center){
			
			tmp[index++]=data[left++];
		}
		//������
		while(mid<=right){
			
			tmp[index++]=data[mid++];
		}
		//����ʱ�������Ѿ��źõ�Ԫ��˳���ͻص�ԭʼ�����С�
		while(i<=right){
			
			data[i]=tmp[i++];
		}
	}
}
