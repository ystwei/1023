package com.weikun.graph;

public class TestListDG {//邻接表的无向图
	public static void main(String[] args) {
		String[] vexs = {"V0", "V1", "V2", "V3"};
        String[][] edges = new String[][]{//有向图
            {"V0", "V3"}, 
            {"V1", "V0"}, 
            {"V1", "V2"},            
            {"V2", "V0"},           
            {"V2", "V1"}            
        };
        
        String[][] edges1 = new String[][]{//无向图，全部表示节点之间的关系即可
                {"V0", "V1"}, 
                {"V0", "V2"}, 
                {"V0", "V3"},  
                {"V1", "V0"},  
                {"V1", "V2"},  
                {"V2", "V1"},
                {"V2", "V0"}, 
                {"V2", "V3"}, 
                {"V3", "V0"},  
                {"V3", "V2"}            
            };
        ListDG d=new ListDG(vexs,edges1);
        d.print();
	}
}
class ListDG{
	
	private class Edge{
		int pos;//该边的顶点在顶点集合的位置
		Edge nextedge;//下一条边的地址
	}
	private class Vertix{//顶点信息
		String data;//顶点名字
		Edge firstedige;//第一个和他相连的边地址
	}
	private Vertix[] top;//顶点数组
	
	ListDG(String vexs[],String edges[][]){
		int vlength=vexs.length;//顶点的个数
		int elength=edges.length;//边的个数
		top=new Vertix[vlength];
		//初始化top顶点数组
		for(int i=0;i<vlength;i++){
			top[i]=new Vertix();
			top[i].data=vexs[i];
			top[i].firstedige=null;
		}
		//初始化边
		for(int i=0;i<elength;i++){
			
			
			int p1=this.getPosition(edges[i][0]);//本身顶点在顶点数组的索引号
			int p2=this.getPosition(edges[i][1]);//另个顶点在顶点数组的索引号
			
			//实例化另外顶点的边
			Edge edge=new Edge();
			edge.pos=p2;
			if(top[p1].firstedige==null){//自身顶点并没有第一个边地址
				top[p1].firstedige=edge;
			}else{//自身顶点已经有第一个边地址了。
				linkLast(top[p1].firstedige,edge);
			}
			
		}
		
	}
	public void print(){
		
		 for (int i = 0; i < top.length; i++) {
			 System.out.printf("%d(%s):",i,top[i].data);
			 Edge edge=top[i].firstedige;
			 while(edge!=null){
				 System.out.printf("%d(%s) ", edge.pos, top[edge.pos].data);
				 
				 edge=edge.nextedge;
			 }
			 System.out.println();
			 
		 }
	}
	 /*
     * 将node节点链接到list的最后
     */
	public Edge linkLast(Edge self,Edge node){
		Edge s=self;
		while(s.nextedge!=null){
			s=s.nextedge;
		}
		s.nextedge=node;
		return s;
	}
	//根据顶点集合，找到每条弧的顶点在其的位置
	public int getPosition(String ch){
		
		for(int i=0;i<top.length;i++){
			if(ch.equals(top[i].data)){
				return i;
			}
			
		}
		return -1;
	}
	
}