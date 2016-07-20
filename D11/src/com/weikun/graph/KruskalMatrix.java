package com.weikun.graph;



public class KruskalMatrix {
	private int ecount;        // 边的数量edge count
	private char[] tops;       // 顶点集合
	private int[][] mMatrix;    // 邻接矩阵
	private static final int INF = Integer.MAX_VALUE;   // 最大值
	
	private class Edge{
		private char start;
		private char end;
		private int weight;
		public Edge(char start ,char end,int weight){
			this.start=start;
			this.end=end;
			this.weight=weight;
			
		}
	}
	/**
	 * 从小到大排边对象
	 * @param edge:边集合
	 * @param count：一共边的个数
	 */
	public void sortEdges(Edge[] edge){
		for(int i=0;i<ecount;i++){
			for(int j=i+1;j<ecount;j++){
				Edge temp=null;
				if(edge[i].weight>edge[j].weight){
					temp=edge[i];
					edge[i]=edge[j];
					edge[j]=temp;
				}
				
			}
		}
	}
	public Edge[] getEdge(){//把邻接矩阵拆解成所有边
		Edge[] edges=new Edge[this.ecount];
		int index=0;
		for(int i=0;i<this.tops.length;i++){
			for(int j=i+1;j<this.tops.length;j++){
				if(this.mMatrix[i][j]!=INF){
					edges[index++]=new Edge(this.tops[i],this.tops[j],this.mMatrix[i][j]);
				}
			}
		}
		return edges;
	}
	/**
	 * 
	 * @param vexs：顶点集合
	 * @param matrix：邻接矩阵
	 */
	
	public KruskalMatrix(char[] vexs, int[][] matrix) {
		// TODO Auto-generated constructor stub
		
		this.tops=vexs;
		this.mMatrix=matrix;
		//统计有多少有效边：非INF和非0的
		for(int i=0;i<this.tops.length;i++){
			for(int j=i+1;j<this.tops.length;j++){
				if(this.mMatrix[i][j]!=INF){
					ecount++;
				}
			}
		}
	}




	public static void main(String[] args) {
		char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		int matrix[][] = {
				       /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
				/*A*/ {   0,  12, INF, INF, INF,  16,  14},
				/*B*/ {  12,   0,  10, INF, INF,   7, INF},
				/*C*/ { INF,  10,   0,   3,   5,   6, INF},
				/*D*/ { INF, INF,   3,   0,   4, INF, INF},
				/*E*/ { INF, INF,   5,   4,   0,   2,   8},
				/*F*/ {  16,   7,   6, INF,   2,   0,   9},
				/*G*/ {  14, INF, INF, INF,   8,   9,   0}
				};


		KruskalMatrix pG = new KruskalMatrix(vexs, matrix);

	
	
		pG.kruskal();   // Kruskal算法生成最小生成树
	}




	private void kruskal() {
		// TODO Auto-generated method stub
		int index=0;
		//声明已有最小生成树的终点数组，存索引
		int tend[]=new int[this.tops.length];
		//声明最下生成树的边集合
		Edge[] result=new Edge[ecount];
		
		//声明原始边数组
		Edge edges[]=this.getEdge();
		//排序权值，从小到大
		this.sortEdges(edges);
		
		for(int i=0;i<ecount;i++){
			//根据边的start值，找到在tops中的索引号
			int p1=this.getPosition(edges[i].start);//E
			int p2=this.getPosition(edges[i].end);//F
			
			
			int e1=this.getEnd(tend, p1);//找到其在tends集合是是否存在，存在就返回其索引
			
			int e2=this.getEnd(tend, p2);
			
			if(e1!=e2){//没有形成回路
				
				tend[e1]=e2;
				result[index++]=edges[i];
			}
		}
		//累计权值
		int sum=0;
		
		for(int i=0;i<index;i++){
			System.out.println(result[i].start+"----"+result[i].end);
			sum+=result[i].weight;
			
		}
		System.out.println(sum);
		
	}
	/**
	 * tends:终点的集合，判断回路的
	 * @param index:找的点在tends集合中是否存在，如果存在，证明他已经是其他点的另外连接点了，会构成回路
	 * @return：如果找到返回该点在tends的索引
	 */
	private int getEnd(int tends [],int index){
		while(tends[index]!=0){
			index=tends[index];
			
		}
		return index;
	}
	/**
	 * 
	 * @param start:边开始点在tops中的索引
	 * @return：边结束点在tops中的索引
	 */
	private int getPosition(char start) {
		// TODO Auto-generated method stub
		for(int i=0;i<tops.length;i++){
			if(tops[i]==start){
				return i;
			}
			
		}
		return -1;
	}

}

