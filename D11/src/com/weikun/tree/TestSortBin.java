package com.weikun.tree;






public class TestSortBin {
	public static void main(String[] args) {
		BinaryTree b=new BinaryTree();
		BinaryTree.TreeNode a=b.init();
//		b.xianSort(a);//A B D E H I C F J G P
		//b.houSort(a);//D H I E B J F P G C A
		b.zhongSort(a);//D B H E I A F J C P G
	}
}
class BinaryTree{
	static class TreeNode<T>{
		private T data;
		private TreeNode<T> leftNode;
		private TreeNode<T> rightNode;
		public TreeNode(T data,TreeNode<T> leftNode,TreeNode<T> rightNode){
			this.data=data;
			this.leftNode=leftNode;
			this.rightNode=rightNode;
		}
		public T getData(){
			return data;
			
		}
		
		public TreeNode<T> getLeftNode(){
			return leftNode;
		}
		
		public TreeNode<T> getRightNode(){
			return rightNode;
		}
		
		
	}	
	//初始化二叉树
		/*
		 * 				    A
		 * 				/		\
		 * 			 B             C
		 * 			/ \          /   \
		 * 		   D    E       F       G
		 *             / \       \     /
		 * 			  H   I       J   P	 
		 * D B H E I A F J C P G
		 * 
		 */
	public TreeNode init(){//构建二叉树
		TreeNode  d=new TreeNode("D",null,null);
		TreeNode  h=new TreeNode("H",null,null);
		TreeNode  i=new TreeNode("I",null,null);
		TreeNode  j=new TreeNode("J",null,null);
		TreeNode  p=new TreeNode("P",null,null);
		
		TreeNode<String> g=new TreeNode<String>("G",p,null);		
		TreeNode<String> f=new TreeNode<String>("F",null,j);
		TreeNode<String> e=new TreeNode<String>("E",h,i);
		TreeNode<String> b=new TreeNode<String>("B",d,e);
		TreeNode<String> c=new TreeNode<String>("C",f,g);
		TreeNode<String> a=new TreeNode<String>("A",b,c);//大根
		return a;
	}
	
	//打印当前节点数据
	public void printNode(TreeNode node){
		System.out.println(node.getData()+" ");		
	}
	public void xianSort(TreeNode node){
		this.printNode(node);//中
		if(node.leftNode!=null){
			this.xianSort(node.leftNode);
		}
		
		if(node.rightNode!=null){
			this.xianSort(node.rightNode);
		}
	}
	public void houSort(TreeNode node){
		
		if(node.leftNode!=null){
			this.houSort(node.leftNode);
		}
		
		if(node.rightNode!=null){
			this.houSort(node.rightNode);
		}
		this.printNode(node);//中
	}
	public void zhongSort(TreeNode node){
		
		if(node.leftNode!=null){
			this.zhongSort(node.leftNode);
		}
		this.printNode(node);//中
		if(node.rightNode!=null){
			this.zhongSort(node.rightNode);
		}
		
	}
}


