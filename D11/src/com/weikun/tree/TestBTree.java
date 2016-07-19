package com.weikun.tree;





public class TestBTree {
	private static final int arr[] = {1,5,4,3,2,6};
	/*
	 * 		    1
	 * 		     \ 
	 *            5
	 *          /   \
	 *         4     6
	 *        /
	 *       3
	 *      /
	 *     2
	 */
	public static void main(String[] args) {
		int i, ilen;
		BSTree tree=new BSTree();

		System.out.print("== 依次添加: ");
		ilen = arr.length;
		for(i=0; i<ilen; i++) {
			System.out.print(arr[i]+" ");
			tree.insert(arr[i]);
		}
		System.out.print("\n== 前序遍历DLR: ");
		tree.preOrder();

		System.out.print("\n== 中序遍历LDR: ");
		tree.inOrder();

		System.out.print("\n== 后序遍历LRD: ");
		tree.postOrder();
		System.out.println();

		
		
		System.out.println("== 树的详细信息: ");
		tree.print();

		System.out.print("\n== 删除节点: "+ arr[5]);
		tree.remove(arr[5]);

		System.out.print("\n== 中序遍历: ");
		tree.inOrder();
		System.out.println();

	
	}
	
	
}
class BSTree {
	BSTreeNode root;//根节点
	public class BSTreeNode implements Comparable{
		Integer key;

		BSTreeNode left;
		BSTreeNode right;

		BSTreeNode parent;
		BSTreeNode(Integer key,BSTreeNode parent,BSTreeNode left,BSTreeNode right){
			this.key=key;
			this.parent=parent;
			this.left=left;
			this.right=right;

		}
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			BSTreeNode other=(BSTreeNode)o;
			return this.key-other.key;
		}
	}

	/*递归实现，查找二叉树x中键值为key的节点
	 * 
	 */
	private BSTreeNode search(BSTreeNode x,Integer key){
		if(x==null){
			return x;
		}
		int cmp=key.compareTo(x.key);
		if(cmp<0){//小于当前节点的值，将在左树中查
			return search(x.left,key);
		}else if(cmp>0){//大于当前节点的值，将在右树中查
			return search(x.right,key);
		}else{
			return x;
		}		
	}
	//前序遍历DLR
	private void preOrder(BSTreeNode tree){
		if(tree!=null){
			System.out.print(tree.key+" ");
			preOrder(tree.left);
			preOrder(tree.right);
		}		
	}
	public void preOrder(){
		preOrder(root);
	}
	//中序遍历 LDR
	private void inOrder(BSTreeNode tree){
		if(tree!=null){
			inOrder(tree.left);
			System.out.print(tree.key+" ");
			inOrder(tree.right);
		}
	}
	public void inOrder(){
		this.inOrder(root);
	}
	//后序遍历 LRD
	private void postOrder(BSTreeNode tree){
		if(tree!=null){
			postOrder(tree.left);
			postOrder(tree.right);
			System.out.print(tree.key+" ");
		}
	}
	public void postOrder(){
		postOrder(root);
	}
	public BSTreeNode max(BSTreeNode node){// 查找最大结点，返回tree为根节点的二叉树的最大节点，在右侧找
		if(node==null){
			return null;
		}
		while(node.right!=null){
			node=node.right;
			
		}
		return node;
	}
	
	public BSTreeNode min(BSTreeNode node){// 查找最小结点，返回tree为根节点的二叉树的最小节点，在左侧找
		if(node==null){
			return null;
		}
		while(node.left!=null){
			node=node.left;
			
		}
		return node;
	}
	
	/*后继节点
	 * 找结点x的后继节点，即，查找二叉树中数据值大于该节点的最小节点
	 */
	public BSTreeNode successor(BSTreeNode x){
		if(x.right!=null){//有左链
			return this.min(x.right);
		}
		
		if(x.parent==null){
			System.out.println("没有后继");
			return null;
		}
		BSTreeNode y=x.parent;//先找到其父亲
		//没有右链，
		//2a:x是一个左孩子，那么x的后继就是其父亲
		//2b:x是一个右孩子，那么x的后继是其父亲的父亲，且第一个父亲的右链
		
		while(y!=null && x==y.right){
			
			x=y;
			y=y.parent;
					
		}
		return y;
	}
	public void insert(Integer key){
		BSTreeNode z=new BSTreeNode(key,null,null,null);
		//如果新建节点失败，则返回
		if(z!=null){
			insert(this,z);
		}
	}
	/* 将节点插入到二叉树中
	 * tree：二叉树
	 * z：插入的节点 */	
	private void insert(BSTree tree,BSTreeNode z){
		
		BSTreeNode y=null;
		BSTreeNode x=tree.root;
		while(x!=null){
			y=x;
			if(z.compareTo(x)>0){
				x=x.right;
			}else if(z.compareTo(x)<0){
				x=x.left;
			}else{
				System.out.println("节点值重复");
				return;
			}
			
		}
		z.parent=y;//要加到当前节点的儿子上，y就是他父亲
		if(y==null){//没有父亲,加在根上
			tree.root=z;
			
		}else {
			if(z.compareTo(y)>0){
				y.right=z;
			}else if(z.compareTo(y)<0){
				y.left=z;
			}else{
				System.out.println("节点值重复");
				return;
			}
		}
				
		
	
	}
	
	/*
	 * 删除节点z，并返回被删除的节点
	 * bst：二叉树
	 * z删除的节点
	 * 1.没有儿子，即为叶结点。直接把父结点的对应儿子指针设为NULL，就OK了。
	   2.只有一个儿子。那么把父结点的相应儿子指针指向儿子的独生子，删除儿子结点也OK了。
	   3.有两个儿子。这是最麻烦的情况，因为你删除节点之后，还要保证满足搜索二叉树的结构。其实也比较容易，
	   我们可以选择左儿子中的最大元素或者右儿子中的最小元素放到待删除节点的位置，就可以保证结构的不变。
	   当然，你要记得调整子树，毕竟又出现了节点删除。习惯上大家选择左儿子中的最大元素，其实选择右儿子的最小元素也一样，
	   没有任何差别，只是人们习惯从左向右。这里咱们也选择左儿子的最大元素，将它放到待删结点的位置。
	   左儿子的最大元素其实很好找，只要顺着左儿子不断的去搜索右子树就可以了，直到找到一个没有右子树的结点。那就是最大的了。
	 */
	private BSTreeNode remove(BSTree tree,BSTreeNode z){
		BSTreeNode x=null;
		BSTreeNode y=null;
		
		if(z.left==null||z.right==null){//或没有左 或没有右
			y=z;
		}else{//既有左又由右，找到其后继节点
			
			y=this.successor(z);
		}
		
		//找到其后继节点的左子或者右子
		if(y.left!=null){
			x=y.left;
		}else{
			x=y.right;
		}
		if(x!=null){//代表有值
			x.parent=y.parent;
		}
		
		//把后继节点抠出去，在把他原有的左链或右链弄过去
		
		if(y.parent==null){
			tree.root=x;
		}else if(y==y.parent.left){
			y.parent.left=x;//把后继的左链付过去
		}else{
			
			y.parent.right=x;//把后继的右链付过去
		}		
		
		if(y!=z){
			z.key=y.key;
		}
		return y;
	}
	
	//找到x的前驱节点：/查找该节点(x)的前驱节点，即查找二叉树中数据值小于该节点的最大节点
	public BSTreeNode predecessor(BSTreeNode x){
		if(x.left!=null){//有左链
			return this.max(x.left);
		}
		//没有左链，
		//2a:x是一个右孩子，那么x的前驱就是其父亲
		if(x.parent==null){
			System.out.println("没有前驱");
			return null;
		}
		BSTreeNode y=x.parent;//先找到其父亲
		
		//2b:x是一个左孩子，那么x的前驱是其父亲的父亲，且第一个父亲的右链
		
		while(y!=null && x==y.left){
			
			x=y;
			y=y.parent;
					
		}
		return y;
		
		
	}
	/*
	 * 打印"二叉查找树"
	 *
	 * key        -- 节点的键值 
	 * direction  --  0，表示该节点是根节点;
	 *               -1，表示该节点是它的父结点的左孩子;
	 *                1，表示该节点是它的父结点的右孩子。
	 */
	private void print(BSTreeNode tree, Integer key, int direction) {

		if(tree != null) {

			if(direction==0)  {  // tree是根节点
				System.out.printf("%2d is root\n", tree.key);
			}else{                // tree是分支节点
				System.out.printf("%2d is %2d's %6s child\n", tree.key, key, direction==1?"right" : "left");
			}

			print(tree.left, tree.key, -1);
			print(tree.right,tree.key,  1);
		}
	}

	public void print() {
		if (root != null)
			print(root, root.key, 0);
	}
	
	/*
	 * 删除节点z，并返回被删除的节点
	 * tree：二叉树的根节点
	 * z 删除的节点
	 */
	public void remove(Integer key){
		BSTreeNode z, node;
		if((z=this.search(root, key))!=null){
			if((node=remove(this,z))!=null){
				node=null;
			}
		}
	}
}