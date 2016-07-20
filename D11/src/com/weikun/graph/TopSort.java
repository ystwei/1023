package com.weikun.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;





public class TopSort {
	 // �ڽӱ��б��Ӧ������Ķ���
    private class ENode {
        int itop;       // �ñ���ָ��Ķ����λ��
        ENode next; // ָ����һ������ָ��
    }

    // �ڽӱ��б�Ķ���
    private class VNode {
        char data;          // ������Ϣ
        ENode firstEdge;    // ָ���һ�������ö���Ļ�
    };

    private List<VNode> mVexs;  // ��������
    
    /**
     * 
     * @param vexs :���㼯��
     * @param edges���߼���
     */
    public TopSort(char[] vexs, char[][] edges){
    	int vlen=vexs.length;
    	int elen=edges.length;
    	mVexs=new ArrayList<VNode>();
    	for(int i=0;i<vlen;i++){//��ʼ������
    		
    		VNode v=new VNode();
    		v.data=vexs[i];
    		v.firstEdge=null;
    		mVexs.add(v);
    		
    	}
    	//��ʼ����
    	for(int i=0;i<elen;i++){
    		
    		char c1=edges[i][0];
    		char c2=edges[i][1];
    		
    		int p1=this.getPosition(c1);//�ҵ��䶥���ڶ��㼯���е�λ��
    		int p2=this.getPosition(c2);//�ҵ��䶥���ڶ��㼯���е�λ��
    		
    		//��ʼ����
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
         int num = mVexs.size();//��������ĸ���

         int[] in   = new int[num];//// �������
         char[] results  = new char[num];// �������������飬��¼ÿ���ڵ����������š�
         Queue<Integer> queue = new LinkedList<Integer>();// ��������
         //�ҵ����ж��������
         for(int i=0;i<this.mVexs.size();i++){
        	 ENode first=this.mVexs.get(i).firstEdge;
        	 if(first!=null){
        		 while(first!=null){
        			 
        			 in[first.itop]++;
        			 first=first.next;
        		 }
        	 }
         }
         //�������Ϊ0����queue����
         for(int i=0;i<in.length;i++){
        	 if(in[i]==0){//���Ϊ0
        		 queue.offer(i);
        	 }
         }
         while(!queue.isEmpty()){//֤�������Ϊ0����
        	 
        	 int i=queue.poll().intValue();
        	 results[index++]=this.mVexs.get(i).data;
        	 ENode node=this.mVexs.get(i).firstEdge;
        	 //���
        	 while(node!=null){
        		 in[node.itop]--;
        		 
        		 if(in[node.itop]==0){
        			 queue.offer(node.itop);
        		 }
        		 
        		 node=node.next;
        	 }
        	 
         }
         
      // ��ӡ����������
         System.out.printf("== TopSort: ");
         for(int i = 0; i < num; i ++){
             System.out.printf("%c ", results[i]);
         }
         System.out.printf("\n");
         return 0;
         
         
    }
   /**
    * 
    * @param list���ϱ�
    * @param node:��Ҫ���ӵ��±�
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
    	 char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};//��������
         char[][] edges = new char[][]{//�����飬����A->G B->A��
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
