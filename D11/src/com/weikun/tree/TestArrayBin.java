package com.weikun.tree;

public class TestArrayBin {
	 /* 
	 *      A
	 *       \
	 *        B
	 *       /  
	 *      C
	 *       \
	 *        D
	 * 
	 */
	public static void main(String[] args) {
		ArrayBin bin=new ArrayBin(8,"A");
		bin.add(0, "B",false );
		bin.add(2, "C",true );
		bin.add(5, "D",false );
		
		System.out.println(bin.left(2));
		//System.out.println(bin.right(1));
	}
}
class ArrayBin{
	private Object[] datas;	
	//������������
	private int deep=8;
	private int arraySize;//�������ܽڵ�ĸ���
	//��Ĭ�ϵ����������������
	ArrayBin(){

		this.arraySize=(int)Math.pow(2, this.deep)-1;//�ܹ��ڵ����

		datas=new Object[this.arraySize];//���ٿռ�


	}

	ArrayBin(int deep){
		this.deep=deep;
		this.arraySize=(int)Math.pow(2, this.deep)-1;//�ܹ��ڵ����

		datas=new Object[this.arraySize];//���ٿռ�


	}
	
	
	ArrayBin(int deep,String data){
		this.deep=deep;
		this.arraySize=(int)Math.pow(2, this.deep)-1;//�ܹ��ڵ����

		datas=new Object[this.arraySize];//���ٿռ�
		datas[0]=data;


	}
	/**
	 * 
	 * @param parentIndex:���ڵ������
	 * @param data����ǰ�ڵ�����
	 * @param left���Ƿ�Ϊ��
	 */
	public void add(int parentIndex,String data,boolean left){
		if(datas[parentIndex] ==null){
			System.out.println("�������������");
			return ;
		}
		if(2*parentIndex+1>=this.arraySize){//
			System.out.println("�����Ѿ�����");
			return ;
		}
		if(left){//��������parentIndex�ڵ�����ӽڵ�
			datas[2*parentIndex+1]=data;

		}else{//���ӽڵ�
			datas[2*parentIndex+2]=data;
		}


	}
	//���ص�ǰ�ڵ�����ӽڵ�
	public Object left(int parentIndex){
		
		if(this.arraySize<2*parentIndex+1){
			System.out.println("û������");
			return null;
		}
		return datas[2*parentIndex+1];
		
	}

	//���ص�ǰ�ڵ�����ӽڵ�
	public Object right(int parentIndex){
		if(this.arraySize<2*parentIndex+2){
			System.out.println("û������");
			return null;
		}
		return datas[2*parentIndex+2];
	}


}
