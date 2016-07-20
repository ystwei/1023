package com.weikun.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;





public class TopSort {
	 // 邻接表中表对应的链表的顶点
    private class ENode {
        int itop;       // 该边所指向的顶点的位置
        ENode next; // 指向下一条弧的指针
    }

    // 邻接表中表的顶点
    private class VNode {
        char data;          // 顶点信息
        ENode firstEdge;    // 指向第一条依附该顶点的弧
    };

    private List<VNode> mVexs;  // 顶点数组
    
    /**
     * 
     * @param vexs :顶点集合
     * @param edges：边集合
     */
    public TopSort(char[] vexs, char[][] edges){
    	int vlen=vexs.length;
    	int elen=edges.length;
    	mVexs=new ArrayList<VNode>();
    	for(int i=0;i<vlen;i++){//初始化顶点
    		
    		VNode v=new VNode();
    		v.data=vexs[i];
    		v.firstEdge=null;
    		mVexs.add(v);
    		
    	}
    	//初始化边
    	for(int i=0;i<elen;i++){
    		
    		char c1=edges[i][0];
    		char c2=edges[i][1];
    		
    		int p1=this.getPosition(c1);//找到其顶点在顶点集合中的位置
    		int p2=this.getPosition(c2);//找到其顶点在顶点集合中的位置
    		
    		//初始化边
    		ENode e=new ENode();
    		e.itop=p2;
    		if(mVexs.get(p1).firstEdge==null){
    			mVexs.get(p1).firstEdge=e;
    		}else{
    			
    			linkLast(mVexs.get(p1).firstEdge,e);
    		}
    		
    		
    		
    	}
    	
    	
    }
    public int topologicalSort() {
    	
    	
    	 int index = 0;
         int num = mVexs.size();//顶点数组的个数

         int[] in   = new int[num];//// 入度数组
         char[] results  = new char[num];// 拓扑排序结果数组，记录每个节点的排序后的序号。
         Queue<Integer> queue = new LinkedList<Integer>();// 辅助队列
         //找到所有定的入度数
         for(int i=0;i<this.mVexs.size();i++){
        	 ENode first=this.mVexs.get(i).firstEdge;
        	 if(first!=null){
        		 while(first!=null){
        			 
        			 in[first.itop]++;
        			 first=first.next;
        		 }
        	 }
         }
         //所有入度为0的入queue队列
         for(int i=0;i<in.length;i++){
        	 if(in[i]==0){//入度为0
        		 queue.offer(i);
        	 }
         }
         while(!queue.isEmpty()){//证明有入度为0的类
        	 
        	 int i=queue.poll().intValue();
        	 results[index++]=this.mVexs.get(i).data;
        	 ENode node=this.mVexs.get(i).firstEdge;
        	 //拆边
        	 while(node!=null){
        		 in[node.itop]--;
        		 
        		 if(in[node.itop]==0){
        			 queue.offer(node.itop);
        		 }
        		 
        		 node=node.next;
        	 }
        	 
         }
         
      // 打印拓扑排序结果
         System.out.printf("== TopSort: ");
         for(int i = 0; i < num; i ++){
             System.out.printf("%c ", results[i]);
         }
         System.out.printf("\n");
         return 0;
         
         
    }
   /**
    * 
    * @param list：老边
    * @param node:将要连接的新边
    */
    private void linkLast(ENode list, ENode node) {
    	ENode p=list;
    	while(p.next!=null){
    		p=p.next;
    	}
    	p.next=node;
    }
    public int getPosition(char c){
    	for(int i=0;i<this.mVexs.size();i++){
    		if(mVexs.get(i).data==c){
    			return i;
    		}
    		
    	}
    	return -1;
    	
    }
    public static void main(String[] args) {
    	 char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};//顶点数组
         char[][] edges = new char[][]{//边数组，例如A->G B->A等
             {'A', 'G'}, 
             {'B', 'A'}, 
             {'B', 'D'}, 
             {'C', 'F'}, 
             {'C', 'G'}, 
             {'D', 'E'}, 
             {'D', 'F'}}; 
         
		TopSort t=new TopSort(vexs,edges);
		t.topologicalSort();
	}
}
