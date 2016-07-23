package com.weikun.search;




public class AVLTree<T extends Comparable<T>> {

	private AVLTreeNode<T> mRoot;
	class AVLTreeNode<T extends Comparable<T>>{
		T key;//节点值
		int height;//子节点的最大高度
		AVLTreeNode<T> left;
		AVLTreeNode<T> right;
		public AVLTreeNode(T key,AVLTreeNode<T> left,AVLTreeNode<T> right){
			this.key=key;
			this.left=left;
			this.right=right;
			this.height=0;
		}


	}
	public AVLTree(){
		this.mRoot=null;
	}
	private int height(AVLTreeNode<T> node){//返回任意节点的高度
		if(node!=null){
			return node.height;
		}
		return 0;
	}
	public int height(){
		return height(this.mRoot);
	}
	/**
	 * 比较a和b的最大值，比较两个节点的height
	 * @param a
	 * @param b
	 * @return
	 */

	public int max(int a,int b){
		return a>b?a:b;
	}
	/**
	 * 
	 * @param node:要前序遍历点
	 * DLR
	 */
	private void preOrder(AVLTreeNode<T> node){

		if(node!=null){
			System.out.println(node.key);
			preOrder(node.left);
			preOrder(node.right);
		}

	}
	public void preOrder(){
		this.preOrder(this.mRoot);
	}

	/*
	 * 中序遍历"AVL树"
	 * LDR
	 */
	private void inOrder(AVLTreeNode<T> tree) {
		if(tree != null){
			inOrder(tree.left);
			System.out.print(tree.key+" ");
			inOrder(tree.right);
		}
	}

	public void inOrder() {
		inOrder(mRoot);
	}

	/*
	 * 后序遍历"AVL树"
	 * LRD
	 */
	private void postOrder(AVLTreeNode<T> tree) {
		if(tree != null) {
			postOrder(tree.left);
			postOrder(tree.right);
			System.out.print(tree.key+" ");
		}
	}

	public void postOrder() {
		postOrder(mRoot);
	}
	
	/**
	 * 返回某个节点的最小节点，一定在左子树上查
	 * @param node
	 * @return
	 */
	private AVLTreeNode<T> min(AVLTreeNode<T> node){
		
		
		if(node==null){
			return null;
		}
		while(node.left!=null){
			
			node=node.left;
		}
		return node;
	}
	public T min(){
		AVLTreeNode <T> node=this.min(this.mRoot);
		
		if(node!=null){
			return node.key;
		}
		return null;
		
	}
	
	private AVLTreeNode<T> max(AVLTreeNode<T> node){
		
		
		if(node==null){
			return null;
		}
		while(node.right!=null){
			
			node=node.right;
		}
		return node;
	}
	public T max(){
		AVLTreeNode <T> node=this.max(this.mRoot);
		
		if(node!=null){
			return node.key;
		}
		return null;
		
	}
	/*插入的节点是当前节点的左链的左子节点
	 * k2:最小不平衡子树的那个点
	 * 返回是旋转后的根节点
	 * 
	 * 					A
	 * 				   / 
	 * 				  B        =>LL           B        
	 * 				/   \                    /  \
	 *             X     C                  X    A
	 *                                          /
	 *                                         C
	 * 
	 */
	public AVLTreeNode<T> ll(AVLTreeNode<T> k2){//k2:A
		AVLTreeNode<T> k1;//B
		k1=k2.left;//a的左子就是B
		k2.left=k1.right;//b的右子付给a的左子
		k1.right=k2;//b的右子是A
		//计算k1和k2的最大height
		
		k2.height=this.max(height(k2.left), height(k2.right))+1;
		int height2=this.max(height(k1.left), k2.height)+1;
		
		k1.height=height2;
		
		return k1;
		
	}
	/**插入的节点是当前节点的右链的右子节点
	 * 
	 * 返回是旋转后的根节点
	 * @param k2：最小不平衡子树的那个点
	 * @return返回是旋转后的根节点
	 *  
	 *         A
	 *          \                      B
	 *           B    =>>RR           /  \   
	 *         /  \                  A    X
	 *        C    X                  \
	 *                                 C
	 */
	public AVLTreeNode<T> 
	rr(AVLTreeNode<T> k2){//node:A
		AVLTreeNode<T> k1;//B
		
		k1=k2.right;
		k2.right=k1.left;
		k1.left=k2;
		k2.height=this.max(height(k2.left), height(k2.right))+1;
		k1.height=this.max(height(k1.right), k2.height)+1;
		
		
		return k1;
	}
	
	
	/**插入的节点是当前节点的左链的右子节点
	 * 
	 * 返回是旋转后的根节点
	 * @param k2：最小不平衡子树的那个点
	 * @return返回是旋转后的根节点
	 *  
	 *          A                   A
	 *         /                   /    
	 *        B       =>>先RR      X      ==>再LL   X  
	 *         \                 /                / \
	 *          X               B                B   A
	 *                                         
	 *                                        
	 */
	public AVLTreeNode<T> lr(AVLTreeNode<T> k2){//node:A
		//先RR，再LL
		k2.left= this.rr(k2.left);
		
		return this.ll(k2);
	}
	
	/**插入的节点是当前节点的右链的左子节点
	 * 
	 * 返回是旋转后的根节点
	 * @param k2：最小不平衡子树的那个点
	 * @return返回是旋转后的根节点
	 *  
	 *          A                    A
	 *           \                    \    
	 *            B    =>>先LL          X   ==>再RR    X  
	 *           /                      \            / \
	 *          X                        B          A   B
	 *                                         
	 *                                        
	 */
	public AVLTreeNode<T> rl(AVLTreeNode<T> k2){//node:A
		//先RR，再LL
		k2.right= this.ll(k2.right);
		
		return this.rr(k2);
	}
	/**
	 * 
	 * @param tree:插入的新节点
	 * @param key：插入节点值
	 * @return
	 */
	private AVLTreeNode<T> insert(AVLTreeNode<T> node, T key) {
		if(node==null){//新节点
			node=new AVLTreeNode<T>(key,null,null);
		}else{//现在该树右节点
			int cmp=key.compareTo(node.key);
			
			if(cmp<0){
				node.left=insert(node.left,key);
				if(height(node.left)-height(node.right)==2){//打破平衡，需要旋转，具体是哪种那
					if(key.compareTo(node.left.key)<0){
						node=this.ll(node);
					}else{
						node=this.lr(node);
					}
					
				}
			}else if(cmp>0){
				node.right=insert(node.right,key);
				if(height(node.right)-height(node.left)==2){//打破平衡
					if(key.compareTo(node.right.key)>0){
						node =this.rr(node);
					}else{
						node=this.rl(node);
					}
					
				}
			}else{
				System.out.println("不能创建二叉树");
			}
			
		}
		node.height=this.max(height(node.left), height(node.right))+1;
		return node;
	}
	public void insert(T key) {
		mRoot = insert(mRoot, key);
	}
	/*
	 * 打印"二叉查找树"
	 *
	 * key        -- 节点的键值 
	 * direction  --  0，表示该节点是根节点;
	 *               -1，表示该节点是它的父结点的左孩子;
	 *                1，表示该节点是它的父结点的右孩子。
	 */
	private void print(AVLTreeNode<T> tree, T key, int direction) {
		if(tree != null) {
			if(direction==0)    // tree是根节点
				System.out.printf("%2d is root\n", tree.key, key);
			else                // tree是分支节点
				System.out.printf("%2d is %2d's %6s child\n", tree.key, key, direction==1?"right" : "left");

			print(tree.left, tree.key, -1);
			print(tree.right,tree.key,  1);
		}
	}

	public void print() {
		if (mRoot != null)
			print(mRoot, mRoot.key, 0);
	}
	private static int arr[]= {3,2,1,4,5,6,7,10,9,8};

	public static void main(String[] args) {
		int i;
		AVLTree<Integer> tree = new AVLTree<Integer>();

		System.out.printf("== 依次添加: ");
		for(i=0; i<arr.length; i++) {			
			//tree.insert(arr[i]);
			tree.mRoot=tree.insert(tree.mRoot,arr[i]);
			System.out.printf("%d ", arr[i]);
		}
		System.out.printf("\n== 前序遍历: ");
		tree.preOrder();
		System.out.printf("\n== 中序遍历: ");
		tree.inOrder();
		System.out.printf("\n== 后序遍历: ");
		tree.postOrder();
		System.out.printf("\n");
		System.out.printf("== 高度: %d\n", tree.height());
		
		System.out.printf("== 树的详细信息: \n");
		tree.print();


		
	}
}
