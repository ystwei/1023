package com.weikun.sort;

public class E {//Shell����
	
	
	public static int count = 0;
	private static int [] data={47,55,10,40,15,94,5,70};
	
	public static void main(String[] args) {
		//1���������� h
		int arraylength=data.length;
		int h=0;//������ʼֵ
		
		
		while(h<=arraylength/3){
			
			h=h*3+1;
		}
		
		while(h>0){
			for(int i=h;i<arraylength;i++){
				int tmp=data[i];//�Ȱ�һ�εĺ����ֵ�洢����ʱ������
				
				if(data[i-h]>data[i]){//���һ�ε�ǰ���ֵ���ں����ֵ
					//����ֵ�����˸�Ե�
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
