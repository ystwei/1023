package com.weikun.tree;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;



public class TestBinTreeIterator {//�������ı���
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
	 * �������
	 */
	public void broadIterator(){
		if(root==null){
			System.out.println("����");
			return;
		}
		//���ǿ���
		System.out.print("������ȣ�");
		ArrayDeque<TreeNode> deque=new ArrayDeque<TreeNode>();
		deque.add(root);
		while(deque.isEmpty()==false){//��û���ɾ�

			TreeNode current=deque.remove();//��ǰ�ڵ�
			System.out.print(current.value+" ");
			if(current.left!=null){
				deque.add(current.left);
			}
			if(current.right!=null){
				deque.add(current.right);
			}
		}

	}
	//��ȱ���
	/*
	 * ������ȣ��õ�Stack
	 * 
	 * 
	 * 	 				      0
	 *  				  /      \
	 *  			     1        2
	 *  			   /    \    / \
	 *                3      4  5   6
	 *               / \    /
	 *              7   8  9
	 * ����ǣ�0 1 3 7 8 4 9 2 5 6       DLR
	 * */
	public void depthIterator(){
		if(root==null){
			System.out.println("����");
			return;
		}
		//���ǿ���
		System.out.print("������ȣ�");
		Stack<TreeNode> stack=new Stack<TreeNode>();
		stack.push(root);
		while(stack.isEmpty()==false){//��û���ɾ�

			TreeNode current=stack.pop();//��ǰ�ڵ�
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
		//1�������ڵ�
		root=new TreeNode(null,null,values.get(0));
		Queue<TreeNode> queue=new ArrayDeque<TreeNode>();

		queue.add(root);
		//2.���������ӽڵ㣬��Χ��һ���ֹ����ֹ���
		int half=values.size()/2;
		for(int i=0;i<half;i++){
			//2.1�ҵ�����������list�е�����
			if(values.get(i)!=null){//������ָ����ֵ�Ǵ��ڵ�

				TreeNode current=queue.poll();

				int left=2*i+1;
				//2.2 �ҵ���������list�е�����
				int right=2*i+2;
				//3�����ӽڵ�
				if(values.get(left)!=null){//���ӽڵ��ֵ����
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