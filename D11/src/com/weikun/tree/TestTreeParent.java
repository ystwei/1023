package com.weikun.tree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TestTreeParent {
	public static void main(String[] args) {
		TreeParent tp=new TreeParent();
		TreeParent.Node a=tp.addNode("A", tp.root());
		tp.addNode("B", a);
		TreeParent.Node c=tp.addNode("C", tp.root());
		
		List<TreeParent.Node> list=tp.getChildren(tp.root());
		
		for(TreeParent.Node node :list){
			 System.out.println(node.data);
		}
		
		System.out.println(tp.deep());
	}
}
class TreeParent{
	
	
	 static class Node{
		String data;//�ýڵ������
		int parentIndex;//���ڵ������
		
		public Node(String data,int parentIndex){
			this.data=data;
			this.parentIndex=parentIndex;
		}
		
	}
	private int treeSize=100;//���ڵ���ܸ���
	private Node[] nodes;//��¼ÿ�����ڵ�
	
	private int nodeNums;//��¼���ڵĽڵ����
	
	public Node root(){
		return nodes[0];
	}
	public TreeParent(){//ʵ����������ʵ�ʾ��ǶԸ����ĸ��ڵ�Ĳ���
		nodes=new Node[this.treeSize];//�����ٿռ�
		
		nodes[0]=new Node("ROOT",-1);//���ڵ�
		
		nodeNums++;
	}
	//�ҵ�ָ���ڵ��������е�������
	public int pos(Node node){
		
		for(int i=0;i<this.treeSize;i++){
			if(nodes[i]==node){//�ҵ���
				return i;
			}
		}
		return -1;
	}
	public Node addNode(String data,Node parent){//data:�Լ������� ��parent:�����ĸ��ڵ�֮�����ӽڵ�
		Node temp=null;
		for(int i=0;i<this.treeSize;i++){
			if(nodes[i]==null){
				nodes[i]=new Node(data,pos(parent));
				nodeNums++;
				temp=nodes[i];
				break;
			}
			
		}
		return temp;
		
	}
	public List<Node> getChildren(Node parent){
		List<Node> list=new ArrayList<Node>();
		
		for(int i=0;i<this.treeSize;i++){
			
			if(nodes[i]!=null&&nodes[i].parentIndex==pos(parent)){//1.��ǰԪ����ֵ��2.��ǰԪ�ص�parent���ֵ��parent��������
				list.add(nodes[i]);//���ж��Ӷ�������
				
			}
			
		}
		
		
		return list;
		
	}
	//������ڵ�Ĳ��ֵ��ÿ���ڵ�Ĳ㼶ֵ�����Ǹ�
	public int deep(){
		int max=0;
		
		for(int i=0;i<this.treeSize &&nodes[i]!=null;i++){
			
			int def=1;//��1��ʼ
			int m=nodes[i].parentIndex;//��ǰ�ڵ�ĸ��ڵ��������
			
			while(m!=-1&&nodes[m]!=null){//���ܵ����ڵ㣬���ҵ�ǰ���ڵ���ֵ
				m=nodes[m].parentIndex;//�ı�mֵ���ҵ������ĵ�ǰ�ڵ�ĸ��ڵ�
				def++;
			}
			if(def>max){
				max=def;
			}
			
		}
		
		return max;
		
	}
}
