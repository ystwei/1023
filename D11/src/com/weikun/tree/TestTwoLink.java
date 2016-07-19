package com.weikun.tree;

public class TestTwoLink {
	/*
	 *              A
	 *             /  \
	 *            B    C
	 *           /      \
	 *          D        F
	 *         /
	 *        E
	 * 		    \
	 * 			  G
	 */
	public static void main(String[] args) {
		
		TwoLink t=new TwoLink("A");
		
		
		TwoLink.TreeNode b=t.addNode(t.getRoot(), "B", true);
		TwoLink.TreeNode c=t.addNode(t.getRoot(), "C", false);
		
		TwoLink.TreeNode d=t.addNode(b, "D", true);
		TwoLink.TreeNode e=t.addNode(d, "E", true);
		t.addNode(e, "G", false);
		t.addNode(c, "F", false);
		
		System.out.println(t.leftChild(b));
		System.out.println(t.rightChild(c));
		
		
		System.out.println(t.level(b));
	}
}
class TwoLink{
	
	public static class TreeNode{
		Object data;//数据
		TreeNode left;//左指针
		TreeNode right;//右指针
		public TreeNode(){
		}
		public TreeNode(Object data){
			this.data = data;
		}
		public TreeNode(Object data , TreeNode left, TreeNode right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	//根节点
	private TreeNode root;
	TwoLink(){
		
		root=new TreeNode();
	}
	
	TwoLink(String data){
		
		root=new TreeNode(data);
	}
	public TreeNode getRoot(){
		return root;
	}
	/**
	 * 
	 * @param parent:哪个父节点加
	 * @param data:本节点数据
	 * @param isleft:是否是左
	 */
	public TreeNode addNode(TreeNode parent ,String data,boolean isleft){
		
		if(parent==null){
			System.out.println("还没有你爹那！");
			return null;
		}
		if(isleft&&parent.left!=null){
			System.out.println("左不能重复加");
			return null;
		}
		if(!isleft&&parent.right!=null){
			System.out.println("右不能重复加");
			return null;
		}
		TreeNode newnode=new TreeNode(data);
		if(isleft){
			parent.left=newnode;
		}
		if(!isleft){
			parent.right=newnode;
		}
		return newnode;
	}
	/**
	 * 
	 * @param parent:要查找的父节点
	 * @return：当前左子节点的值
	 */
	public Object leftChild(TreeNode parent){
		
		return parent.left==null?null:parent.left.data;
		
		
	}
	public Object rightChild(TreeNode parent){
		
		return parent.right==null?null:parent.right.data;
		
		
	}
	/**
	 * 
	 * @param node:当前节点
	 * @return：当前节点的层数
	 */
	public int level(TreeNode node){
		
		if (node == null){//没节点
			return 0;
		}
		//没有子树
		if (node.left == null && node.right == null){//没左并且没右
			return 1;
		}else{//有左或者右
			int left=level(node.left);
			int right=level(node.right);
			
			return left>right?left+1:right+1;
		}
	}
	
}