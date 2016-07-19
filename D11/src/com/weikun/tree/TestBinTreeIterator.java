package com.weikun.tree;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;



public class TestBinTreeIterator {//二叉树的遍历
	public static void main(String[] args) {
		CreateABinaryTree c=new CreateABinaryTree();
		List<Integer> list=new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		c.createBinTreeByDeque(list);

		c.depthIterator();
		c.broadIterator();
	}
}
class CreateABinaryTree{
	private TreeNode root;

	static class TreeNode{
		TreeNode left;
		TreeNode right;
		Integer value;

		TreeNode(TreeNode left,TreeNode right ,Integer value){
			this.left=left;
			this.right=right;
			this.value=value;
		}
	}

	/*
	 * 广度优先
	 */
	public void broadIterator(){
		if(root==null){
			System.out.println("空树");
			return;
		}
		//不是空树
		System.out.print("广度优先：");
		ArrayDeque<TreeNode> deque=new ArrayDeque<TreeNode>();
		deque.add(root);
		while(deque.isEmpty()==false){//还没倒干净

			TreeNode current=deque.remove();//当前节点
			System.out.print(current.value+" ");
			if(current.left!=null){
				deque.add(current.left);
			}
			if(current.right!=null){
				deque.add(current.right);
			}
		}

	}
	//深度遍历
	/*
	 * 深度优先，用的Stack
	 * 
	 * 
	 * 	 				      0
	 *  				  /      \
	 *  			     1        2
	 *  			   /    \    / \
	 *                3      4  5   6
	 *               / \    /
	 *              7   8  9
	 * 结果是：0 1 3 7 8 4 9 2 5 6       DLR
	 * */
	public void depthIterator(){
		if(root==null){
			System.out.println("空树");
			return;
		}
		//不是空树
		System.out.print("深度优先：");
		Stack<TreeNode> stack=new Stack<TreeNode>();
		stack.push(root);
		while(stack.isEmpty()==false){//还没倒干净

			TreeNode current=stack.pop();//当前节点
			System.out.print(current.value+" ");
			if(current.right!=null){
				stack.push(current.right);
			}
			if(current.left!=null){
				stack.push(current.left);
			}
		}


	}
	public void createBinTreeByDeque(List<Integer> values){//0 1 2 3 4 5 6 
		//1创建根节点
		root=new TreeNode(null,null,values.get(0));
		Queue<TreeNode> queue=new ArrayDeque<TreeNode>();

		queue.add(root);
		//2.创建左右子节点，范围从一半截止，防止溢出
		int half=values.size()/2;
		for(int i=0;i<half;i++){
			//2.1找到左子树的在list中的索引
			if(values.get(i)!=null){//父索引指定的值是存在的

				TreeNode current=queue.poll();

				int left=2*i+1;
				//2.2 找到右子树在list中的索引
				int right=2*i+2;
				//3生成子节点
				if(values.get(left)!=null){//左子节点的值存在
					current.left=new TreeNode(null,null,values.get(left));
					queue.add(current.left);
				}
				if(right<values.size()&&values.get(right)!=null){
					current.right=new TreeNode(null,null,values.get(right));
					queue.add(current.right);
				}

			}






		}




	}
}