package com.weikun.graph;

public class TestListDG {//�ڽӱ������ͼ
	public static void main(String[] args) {
		String[] vexs = {"V0", "V1", "V2", "V3"};
        String[][] edges = new String[][]{//����ͼ
            {"V0", "V3"}, 
            {"V1", "V0"}, 
            {"V1", "V2"},            
            {"V2", "V0"},           
            {"V2", "V1"}            
        };
        
        String[][] edges1 = new String[][]{//����ͼ��ȫ����ʾ�ڵ�֮��Ĺ�ϵ����
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
		int pos;//�ñߵĶ����ڶ��㼯�ϵ�λ��
		Edge nextedge;//��һ���ߵĵ�ַ
	}
	private class Vertix{//������Ϣ
		String data;//��������
		Edge firstedige;//��һ�����������ıߵ�ַ
	}
	private Vertix[] top;//��������
	
	ListDG(String vexs[],String edges[][]){
		int vlength=vexs.length;//����ĸ���
		int elength=edges.length;//�ߵĸ���
		top=new Vertix[vlength];
		//��ʼ��top��������
		for(int i=0;i<vlength;i++){
			top[i]=new Vertix();
			top[i].data=vexs[i];
			top[i].firstedige=null;
		}
		//��ʼ����
		for(int i=0;i<elength;i++){
			
			
			int p1=this.getPosition(edges[i][0]);//�������ڶ��������������
			int p2=this.getPosition(edges[i][1]);//��������ڶ��������������
			
			//ʵ�������ⶥ��ı�
			Edge edge=new Edge();
			edge.pos=p2;
			if(top[p1].firstedige==null){//�����㲢û�е�һ���ߵ�ַ
				top[p1].firstedige=edge;
			}else{//�������Ѿ��е�һ���ߵ�ַ�ˡ�
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
     * ��node�ڵ����ӵ�list�����
     */
	public Edge linkLast(Edge self,Edge node){
		Edge s=self;
		while(s.nextedge!=null){
			s=s.nextedge;
		}
		s.nextedge=node;
		return s;
	}
	//���ݶ��㼯�ϣ��ҵ�ÿ�����Ķ��������λ��
	public int getPosition(String ch){
		
		for(int i=0;i<top.length;i++){
			if(ch.equals(top[i].data)){
				return i;
			}
			
		}
		return -1;
	}
	
}