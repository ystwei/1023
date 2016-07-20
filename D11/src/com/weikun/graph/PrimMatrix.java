package com.weikun.graph;

public class PrimMatrix {
	private char[] mVexs;       // 顶点集合
	private int[][] mMatrix;    // 邻接矩阵
	private static final int INF = Integer.MAX_VALUE;   // 最大值,也就是在邻接矩阵中，两个点如果没有边，就标记最大值
	
	
	/**
	 * 
	 * @param tops：顶点集合
	 * @param matrix1：邻接矩阵 并且带权值
	 */
	public PrimMatrix(char[] tops, int[][] matrix1) {
		// TODO Auto-generated constructor stub
		this.mVexs=tops;
		this.mMatrix=matrix1;
	}
	public void prim(int start){
		//1构建临时数组 prim：方结果值 weight：方权值
		char prim[]=new char[this.mVexs.length];
		int weight[]=new int[this.mVexs.length];
		int index=0;
		prim[index++]=this.mVexs[start];//把A点放到最小生成树的结果数组中
		//把A点不变，其他列改变，和A相关的权值都放到权值数组中。
		for(int i=0;i<this.mVexs.length;i++){
			weight[i]=this.mMatrix[start][i];
			
		}
		//找到和A点相邻顶点的权值最小值
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
			//现在min就是以start为顶点的其他连接点的最小权值，且k是其下个连接顶点的最小索引号
			prim[index++]=this.mVexs[k];//把第二个小的顶点加入到结果数组中
			weight[k]=0;//防止再一次查找
			for(int l=0;l<this.mVexs.length;l++){//以B点为顶点的所有权值之和
				
				if(weight[l]>0 &&this.mMatrix[k][l]<weight[l]){
					weight[l]=this.mMatrix[k][l];//更小的权值
				}
				
			}
			
			
		}
		
		
		//计算在prim数组中每两个点所第代表的权值，依据prim数组，把他们权值加起来，就是最小权值和
		int sum = 0;
		for(int i=1;i<index;i++){
			int min=INF;
			int m=this.getPosition(prim[i]);//B
			//找到下一个和B连接的点A
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
	//根据指定的顶点，找出在顶点集合的位置索引
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
		//INF最大值,也就是在邻接矩阵中，两个点如果没有边，就标记最大值
		 //0 是自己到自己的点的标记
		
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

