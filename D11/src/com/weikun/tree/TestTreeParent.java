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
		String data;//该节点的名字
		int parentIndex;//父节点的索引
		
		public Node(String data,int parentIndex){
			this.data=data;
			this.parentIndex=parentIndex;
		}
		
	}
	private int treeSize=100;//树节点的总个数
	private Node[] nodes;//记录每个树节点
	
	private int nodeNums;//记录现在的节点个数
	
	public Node root(){
		return nodes[0];
	}
	public TreeParent(){//实例化该树，实际就是对该树的根节点的操作
		nodes=new Node[this.treeSize];//开多少空间
		
		nodes[0]=new Node("ROOT",-1);//根节点
		
		nodeNums++;
	}
	//找到指定节点在数组中的索引号
	public int pos(Node node){
		
		for(int i=0;i<this.treeSize;i++){
			if(nodes[i]==node){//找到了
				return i;
			}
		}
		return -1;
	}
	public Node addNode(String data,Node parent){//data:自己的名字 ，parent:加在哪个节点之后当其子节点
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
			
			if(nodes[i]!=null&&nodes[i].parentIndex==pos(parent)){//1.当前元素有值，2.当前元素的parent域的值是parent的索引号
				list.add(nodes[i]);//所有儿子都在这里
				
			}
			
		}
		
		
		return list;
		
	}
	//算出树节点的层次值：每个节点的层级值最大的那个
	public int deep(){
		int max=0;
		
		for(int i=0;i<this.treeSize &&nodes[i]!=null;i++){
			
			int def=1;//从1开始
			int m=nodes[i].parentIndex;//当前节点的父节点的索引号
			
			while(m!=-1&&nodes[m]!=null){//不能到父节点，并且当前父节点有值
				m=nodes[m].parentIndex;//改变m值，找到其他的当前节点的父节点
				def++;
			}
			if(def>max){
				max=def;
			}
			
		}
		
		return max;
		
	}
}
