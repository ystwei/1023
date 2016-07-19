package com.weikun.graph;

public class TestMatrixUDG {//有向图和无向图
	
	
	
	public static void main(String[] args) {
//		char[] vexs = {'A', 'B', 'C', 'D'};
//		char[][] edges = new char[][]{//边是个二维数组，无向图
//				{'A', 'B'},{'B','A'},
//				{'B', 'C'}, {'C', 'B'},
//				{'C', 'D'},{'D', 'C'},
//				{'A', 'D'},{'D','A'},
//				{'A', 'C'},{'C', 'A'}
//
//		}; 
//		
//		char[][] edges1 = new char[][]{//边是个二维数组，有向图
//				{'B','A',},
//				{'B', 'C'}, {'C', 'B'},				
//				{'A', 'D'},
//				{'C', 'A'}
//
//		}; 
//		char[][] edges2 = new char[][]{//边是个二维数组，有向图
//				{'B','A','1'},
//				{'B', 'C','2'}, 
//				{'C', 'B','3'},				
//				{'A', 'D','5'},
//				{'C', 'A','4'}
//
//		}; 
//		
//		
		 char[] vexs = {'A', 'B', 'C', 'D','E','F','G','H','I'};
		 char[][] edges = new char[][]{//边是个二维数组
					{'A', 'B'},
					{'A', 'F'},
					{'B', 'G'},
					{'B', 'C'},
					{'B', 'I'},
					{'C', 'B'},
					{'C', 'I'},
					{'C', 'D'},
					{'D', 'C'},
					{'D', 'I'},
					{'D', 'G'},
					{'D', 'H'},
					{'D', 'E'},
					{'E', 'H'},
					{'E', 'F'},
					{'F', 'G'},
					{'F', 'A'},
					{'F', 'E'},
					{'G', 'H'},
					{'G', 'D'},
					{'G', 'B'},
					{'H', 'G'},
					{'H', 'D'},					
					{'H', 'E'},
					{'I', 'B'},
					{'I', 'C'}
	
			}; 
		MatrixUDG u=new MatrixUDG(vexs,edges);
		u.print();
		u.dfs();
		u.bfs();
	}
}
class MatrixUDG{
	private char [] vexs;//顶点集合
	private int [][] martixI;//边集合
	
	MatrixUDG(char [] vexs ,char [][] martixC){
		this.vexs=vexs;
		//构建边集合
		this.martixI=new int[this.vexs.length][this.vexs.length];
		
		for(int i=0;i<martixC.length;i++){
			
			int p1=this.getPosition(martixC[i][0]);
			int p2=this.getPosition(martixC[i][1]);
			//this.martixI[p1][p2]= martixC[i][2]-48;//适用于带权值的
			this.martixI[p1][p2]= 1;
		}
		
	}
	public void dfs(){
		boolean [] visitied=new boolean[vexs.length];
		for(int i=0;i<vexs.length;i++){
			if(visitied[i]==false){
				dfs(i,visitied);
			}
			
		}
	}
	public void bfs(){
		int [] queue=new int[this.vexs.length];
		int head=0;
		int rear=0;
		boolean visitied[]=new boolean[this.vexs.length];
		
		for(int i=0;i<this.vexs.length;i++){
			
			visitied[i]=false;
		}
		
		
		for(int i=0;i<this.vexs.length;i++){
			if(visitied[i]==false){
				visitied[i]=true;//让他已经访问了
				System.out.printf("%c",this.vexs[i]);
				//操作辅助数组，让其已经访问的索引号 进入队列里
				
				queue[rear++]=i;
			}
			while(head!=rear){//当不相等，代表辅助数组里面有值
				int j=queue[head++];//把第一个索引拿出来
				int k=this.firstVes(j);//以j为顶点的第一个邻接点
				while(k>=0){
					if(visitied[k]==false){
						visitied[k]=true;
						System.out.printf("%c",this.vexs[k]);
						queue[rear++]=k;
					}
					
					
					k=this.nextVes(j, k);
				}
			}
		}
	}
	
	
	//深度优先的核心
	/**
	 * 
	 * @param i:即将要被标记的索引号
	 * @param visitied：是否被访问的数组
	 */
	public void dfs(int i,boolean [] visitied){
		
		visitied[i]=true;//i这个节点已经被访问了
		System.out.printf("%c ", vexs[i]);
		//1马上去找i的第一个邻接节点的索引
		int j=firstVes(i);
		
		while(j>=0){
			if(visitied[j]==false){
				dfs(j,visitied);
			}		
			
			j=nextVes(i,j);
		}
		
	}
	/**
	 * 
	 * @param i:当前点的索引
	 * @param j:下一个邻接点索引
	 * @return：以下一个邻接点索引开始的第一个邻接点索引号
	 */
	private int nextVes(int i,int j) {
		// TODO Auto-generated method stub
		
		if(i<0||i>vexs.length-1||j<0||j>vexs.length-1){
			return -1;//条件错误
		}
		for(int k=j+1;k<vexs.length;k++){
			
			if(this.martixI[i][k]==1){
				return k;
			}
		}
		return -1;
	}
	/**
	 * 
	 * @param i:已经标记过的那个顶点的索引
	 * 通过该索引去找第一个邻接点的索引，找不到返回-1
	 */
	private int firstVes(int i) {
		// TODO Auto-generated method stub
		if(i<0||i>vexs.length-1){
			return -1;//条件错误
		}
		for(int j=0;j<vexs.length;j++){
			
			if(this.martixI[i][j]==1){
				return j;
			}
		}
		return -1;
	}
	//根据指定的顶点值，在vexs找到其顶点的索引号
	public int getPosition(char ch){
		for(int i=0;i<this.vexs.length;i++){
			if(ch==this.vexs[i]){
				return i;
			}
		}
		return -1;
		
	}
	public void print(){
		
		for(int i=0;i<this.vexs.length;i++){
			for(int j=0;j<this.vexs.length;j++){
				System.out.printf("%d ", this.martixI[i][j]);
			}
			System.out.println();
		}
	}
	
}
