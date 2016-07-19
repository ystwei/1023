package com.weikun.graph;

public class TestMatrixUDG {//����ͼ������ͼ
	
	
	
	public static void main(String[] args) {
//		char[] vexs = {'A', 'B', 'C', 'D'};
//		char[][] edges = new char[][]{//���Ǹ���ά���飬����ͼ
//				{'A', 'B'},{'B','A'},
//				{'B', 'C'}, {'C', 'B'},
//				{'C', 'D'},{'D', 'C'},
//				{'A', 'D'},{'D','A'},
//				{'A', 'C'},{'C', 'A'}
//
//		}; 
//		
//		char[][] edges1 = new char[][]{//���Ǹ���ά���飬����ͼ
//				{'B','A',},
//				{'B', 'C'}, {'C', 'B'},				
//				{'A', 'D'},
//				{'C', 'A'}
//
//		}; 
//		char[][] edges2 = new char[][]{//���Ǹ���ά���飬����ͼ
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
		 char[][] edges = new char[][]{//���Ǹ���ά����
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
	private char [] vexs;//���㼯��
	private int [][] martixI;//�߼���
	
	MatrixUDG(char [] vexs ,char [][] martixC){
		this.vexs=vexs;
		//�����߼���
		this.martixI=new int[this.vexs.length][this.vexs.length];
		
		for(int i=0;i<martixC.length;i++){
			
			int p1=this.getPosition(martixC[i][0]);
			int p2=this.getPosition(martixC[i][1]);
			//this.martixI[p1][p2]= martixC[i][2]-48;//�����ڴ�Ȩֵ��
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
				visitied[i]=true;//�����Ѿ�������
				System.out.printf("%c",this.vexs[i]);
				//�����������飬�����Ѿ����ʵ������� ���������
				
				queue[rear++]=i;
			}
			while(head!=rear){//������ȣ�����������������ֵ
				int j=queue[head++];//�ѵ�һ�������ó���
				int k=this.firstVes(j);//��jΪ����ĵ�һ���ڽӵ�
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
	
	
	//������ȵĺ���
	/**
	 * 
	 * @param i:����Ҫ����ǵ�������
	 * @param visitied���Ƿ񱻷��ʵ�����
	 */
	public void dfs(int i,boolean [] visitied){
		
		visitied[i]=true;//i����ڵ��Ѿ���������
		System.out.printf("%c ", vexs[i]);
		//1����ȥ��i�ĵ�һ���ڽӽڵ������
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
	 * @param i:��ǰ�������
	 * @param j:��һ���ڽӵ�����
	 * @return������һ���ڽӵ�������ʼ�ĵ�һ���ڽӵ�������
	 */
	private int nextVes(int i,int j) {
		// TODO Auto-generated method stub
		
		if(i<0||i>vexs.length-1||j<0||j>vexs.length-1){
			return -1;//��������
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
	 * @param i:�Ѿ���ǹ����Ǹ����������
	 * ͨ��������ȥ�ҵ�һ���ڽӵ���������Ҳ�������-1
	 */
	private int firstVes(int i) {
		// TODO Auto-generated method stub
		if(i<0||i>vexs.length-1){
			return -1;//��������
		}
		for(int j=0;j<vexs.length;j++){
			
			if(this.martixI[i][j]==1){
				return j;
			}
		}
		return -1;
	}
	//����ָ���Ķ���ֵ����vexs�ҵ��䶥���������
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
