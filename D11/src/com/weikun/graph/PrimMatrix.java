package com.weikun.graph;

public class PrimMatrix {
	private char[] mVexs;       // ���㼯��
	private int[][] mMatrix;    // �ڽӾ���
	private static final int INF = Integer.MAX_VALUE;   // ���ֵ,Ҳ�������ڽӾ����У����������û�бߣ��ͱ�����ֵ
	
	
	/**
	 * 
	 * @param tops�����㼯��
	 * @param matrix1���ڽӾ��� ���Ҵ�Ȩֵ
	 */
	public PrimMatrix(char[] tops, int[][] matrix1) {
		// TODO Auto-generated constructor stub
		this.mVexs=tops;
		this.mMatrix=matrix1;
	}
	public void prim(int start){
		//1������ʱ���� prim�������ֵ weight����Ȩֵ
		char prim[]=new char[this.mVexs.length];
		int weight[]=new int[this.mVexs.length];
		int index=0;
		prim[index++]=this.mVexs[start];//��A��ŵ���С�������Ľ��������
		//��A�㲻�䣬�����иı䣬��A��ص�Ȩֵ���ŵ�Ȩֵ�����С�
		for(int i=0;i<this.mVexs.length;i++){
			weight[i]=this.mMatrix[start][i];
			
		}
		//�ҵ���A�����ڶ����Ȩֵ��Сֵ
		for(int i=0;i<this.mVexs.length;i++){
			if(i==start){//A ----A  B---B
				continue;
			}
			int j=0;
			int k=0;
			int min=INF;
			while(j<this.mVexs.length){
				
				if(weight[j]>0 && weight[j]<min){
					min=weight[j];
					k=j;
				}
				
				j++;
			}
			//����min������startΪ������������ӵ����СȨֵ����k�����¸����Ӷ������С������
			prim[index++]=this.mVexs[k];//�ѵڶ���С�Ķ�����뵽���������
			weight[k]=0;//��ֹ��һ�β���
			for(int l=0;l<this.mVexs.length;l++){//��B��Ϊ���������Ȩֵ֮��
				
				if(weight[l]>0 &&this.mMatrix[k][l]<weight[l]){
					weight[l]=this.mMatrix[k][l];//��С��Ȩֵ
				}
				
			}
			
			
		}
		
		
		//������prim������ÿ���������ڴ����Ȩֵ������prim���飬������Ȩֵ��������������СȨֵ��
		int sum = 0;
		for(int i=1;i<index;i++){
			int min=INF;
			int m=this.getPosition(prim[i]);//B
			//�ҵ���һ����B���ӵĵ�A
			for(int j=0;j<i;j++){
				int n=this.getPosition(prim[j]);//A				
				if(this.mMatrix[n][m]<min){
					min=this.mMatrix[n][m];
					
				}
			}
			
			sum+=min;
		}
		
		System.out.println(sum);
		
		System.out.println(prim);
	}
	//����ָ���Ķ��㣬�ҳ��ڶ��㼯�ϵ�λ������
	public int getPosition(char c){
		
		for(int i=0;i<this.mVexs.length;i++){
			
			if(this.mVexs[i]==c){
				return i;
				
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		char[] tops = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		//INF���ֵ,Ҳ�������ڽӾ����У����������û�бߣ��ͱ�����ֵ
		 //0 ���Լ����Լ��ĵ�ı��
		
		int matrix1[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
         /*A*/ {   0,  12, INF, INF, INF,  16,  14},
         /*B*/ {  12,   0,  10, INF, INF,   7, INF},
         /*C*/ { INF,  10,   0,   3,   5,   6, INF},
         /*D*/ { INF, INF,   3,   0,   4, INF, INF},
         /*E*/ { INF, INF,   5,   4,   0,   2,   8},
         /*F*/ {  16,   7,   6, INF,   2,   0,   9},
         /*G*/ {  14, INF, INF, INF,   8,   9,   0}
         };
		
		PrimMatrix prim=new PrimMatrix(tops,matrix1);
		prim.prim(0);
	}
}

