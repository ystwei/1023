package com.weikun.sort;

public class B {//������

	private static int [] data={9,79,46,30,58,49};
	public static void main(String[] args) {
		
		
		for(int i=0;i<data.length-1;i++){
			build(data.length-1-i);//�Ѿ�������ϣ������ֵ��0������
			
			
			
			swap(0,data.length-1-i);
			
		}
		
		for(int i:data){
			
			System.out.println(i);
		}
		
		
	}
	//�����󶥶�
	public static  void build(int lastIndex){
		/*
		 *        9
		 *      /   \
		 *    79    46
		 *   / \   /
		 * 30  58 49 
		 */
		
		for(int i=(lastIndex-1)/2;i>=0;i--){
			int k=i;
			while(k*2+1<=lastIndex){//�ж�49���ֵ�������������Ƿ�����Ч��Χ��
				int bigIndex=k*2+1;
				if(bigIndex<lastIndex){//��֤��data[i]�������ӽڵ�
					if(data[bigIndex]-data[bigIndex+1]<0){//֤���ҽڵ�ֵ��
						bigIndex++;
					}
				}
				//bigIndex:�����Ƚϴ�Ľڵ�����,�ڸ����ױ�
				if(data[k]-data[bigIndex]<0){//���ױ���С�����ݴ󶥶ѵĶ��壬���ױ������Ӷ�Ҫ��
					//�Ѵ��ֵ������
					swap(k,bigIndex);
				}else{
					break;
				}
				
			}
			
		}
	}
	public static void swap(int min,int max){
		int tmp=0;
		tmp=data[min];
		data[min]=data[max];
		data[max]=tmp;
		
	}
	
}
