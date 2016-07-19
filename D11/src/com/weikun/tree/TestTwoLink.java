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
		Object data;//����
		TreeNode left;//��ָ��
		TreeNode right;//��ָ��
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
	//���ڵ�
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
	 * @param parent:�ĸ����ڵ��
	 * @param data:���ڵ�����
	 * @param isleft:�Ƿ�����
	 */
	public TreeNode addNode(TreeNode parent ,String data,boolean isleft){
		
		if(parent==null){
			System.out.println("��û������ǣ�");
			return null;
		}
		if(isleft&&parent.left!=null){
			System.out.println("�����ظ���");
			return null;
		}
		if(!isleft&&parent.right!=null){
			System.out.println("�Ҳ����ظ���");
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
	 * @param parent:Ҫ���ҵĸ��ڵ�
	 * @return����ǰ���ӽڵ��ֵ
	 */
	public Object leftChild(TreeNode parent){
		
		return parent.left==null?null:parent.left.data;
		
		
	}
	public Object rightChild(TreeNode parent){
		
		return parent.right==null?null:parent.right.data;
		
		
	}
	/**
	 * 
	 * @param node:��ǰ�ڵ�
	 * @return����ǰ�ڵ�Ĳ���
	 */
	public int level(TreeNode node){
		
		if (node == null){//û�ڵ�
			return 0;
		}
		//û������
		if (node.left == null && node.right == null){//û����û��
			return 1;
		}else{//���������
			int left=level(node.left);
			int right=level(node.right);
			
			return left>right?left+1:right+1;
		}
	}
	
}