package com.weikun.graph;



public class KruskalMatrix {
	private int ecount;        // �ߵ�����edge count
	private char[] tops;       // ���㼯��
	private int[][] mMatrix;    // �ڽӾ���
	private static final int INF = Integer.MAX_VALUE;   // ���ֵ
	
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
	 * ��С�����ű߶���
	 * @param edge:�߼���
	 * @param count��һ���ߵĸ���
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
	public Edge[] getEdge(){//���ڽӾ���������б�
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
	 * @param vexs�����㼯��
	 * @param matrix���ڽӾ���
	 */
	
	public KruskalMatrix(char[] vexs, int[][] matrix) {
		// TODO Auto-generated constructor stub
		
		this.tops=vexs;
		this.mMatrix=matrix;
		//ͳ���ж�����Ч�ߣ���INF�ͷ�0��
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

	
	
		pG.kruskal();   // Kruskal�㷨������С������
	}




	private void kruskal() {
		// TODO Auto-generated method stub
		int index=0;
		//����������С���������յ����飬������
		int tend[]=new int[this.tops.length];
		//���������������ı߼���
		Edge[] result=new Edge[ecount];
		
		//����ԭʼ������
		Edge edges[]=this.getEdge();
		//����Ȩֵ����С����
		this.sortEdges(edges);
		
		for(int i=0;i<ecount;i++){
			//���ݱߵ�startֵ���ҵ���tops�е�������
			int p1=this.getPosition(edges[i].start);//E
			int p2=this.getPosition(edges[i].end);//F
			
			
			int e1=this.getEnd(tend, p1);//�ҵ�����tends�������Ƿ���ڣ����ھͷ���������
			
			int e2=this.getEnd(tend, p2);
			
			if(e1!=e2){//û���γɻ�·
				
				tend[e1]=e2;
				result[index++]=edges[i];
			}
		}
		//�ۼ�Ȩֵ
		int sum=0;
		
		for(int i=0;i<index;i++){
			System.out.println(result[i].start+"----"+result[i].end);
			sum+=result[i].weight;
			
		}
		System.out.println(sum);
		
	}
	/**
	 * tends:�յ�ļ��ϣ��жϻ�·��
	 * @param index:�ҵĵ���tends�������Ƿ���ڣ�������ڣ�֤�����Ѿ�����������������ӵ��ˣ��ṹ�ɻ�·
	 * @return������ҵ����ظõ���tends������
	 */
	private int getEnd(int tends [],int index){
		while(tends[index]!=0){
			index=tends[index];
			
		}
		return index;
	}
	/**
	 * 
	 * @param start:�߿�ʼ����tops�е�����
	 * @return���߽�������tops�е�����
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

