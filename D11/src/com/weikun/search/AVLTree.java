package com.weikun.search;




public class AVLTree<T extends Comparable<T>> {

	private AVLTreeNode<T> mRoot;
	class AVLTreeNode<T extends Comparable<T>>{
		T key;//�ڵ�ֵ
		int height;//�ӽڵ�����߶�
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
	private int height(AVLTreeNode<T> node){//��������ڵ�ĸ߶�
		if(node!=null){
			return node.height;
		}
		return 0;
	}
	public int height(){
		return height(this.mRoot);
	}
	/**
	 * �Ƚ�a��b�����ֵ���Ƚ������ڵ��height
	 * @param a
	 * @param b
	 * @return
	 */

	public int max(int a,int b){
		return a>b?a:b;
	}
	/**
	 * 
	 * @param node:Ҫǰ�������
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
	 * �������"AVL��"
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
	 * �������"AVL��"
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
	 * ����ĳ���ڵ����С�ڵ㣬һ�����������ϲ�
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
	/*����Ľڵ��ǵ�ǰ�ڵ�����������ӽڵ�
	 * k2:��С��ƽ���������Ǹ���
	 * ��������ת��ĸ��ڵ�
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
		k1=k2.left;//a�����Ӿ���B
		k2.left=k1.right;//b�����Ӹ���a������
		k1.right=k2;//b��������A
		//����k1��k2�����height
		
		k2.height=this.max(height(k2.left), height(k2.right))+1;
		int height2=this.max(height(k1.left), k2.height)+1;
		
		k1.height=height2;
		
		return k1;
		
	}
	/**����Ľڵ��ǵ�ǰ�ڵ�����������ӽڵ�
	 * 
	 * ��������ת��ĸ��ڵ�
	 * @param k2����С��ƽ���������Ǹ���
	 * @return��������ת��ĸ��ڵ�
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
	
	
	/**����Ľڵ��ǵ�ǰ�ڵ�����������ӽڵ�
	 * 
	 * ��������ת��ĸ��ڵ�
	 * @param k2����С��ƽ���������Ǹ���
	 * @return��������ת��ĸ��ڵ�
	 *  
	 *          A                   A
	 *         /                   /    
	 *        B       =>>��RR      X      ==>��LL   X  
	 *         \                 /                / \
	 *          X               B                B   A
	 *                                         
	 *                                        
	 */
	public AVLTreeNode<T> lr(AVLTreeNode<T> k2){//node:A
		//��RR����LL
		k2.left= this.rr(k2.left);
		
		return this.ll(k2);
	}
	
	/**����Ľڵ��ǵ�ǰ�ڵ�����������ӽڵ�
	 * 
	 * ��������ת��ĸ��ڵ�
	 * @param k2����С��ƽ���������Ǹ���
	 * @return��������ת��ĸ��ڵ�
	 *  
	 *          A                    A
	 *           \                    \    
	 *            B    =>>��LL          X   ==>��RR    X  
	 *           /                      \            / \
	 *          X                        B          A   B
	 *                                         
	 *                                        
	 */
	public AVLTreeNode<T> rl(AVLTreeNode<T> k2){//node:A
		//��RR����LL
		k2.right= this.ll(k2.right);
		
		return this.rr(k2);
	}
	/**
	 * 
	 * @param tree:������½ڵ�
	 * @param key������ڵ�ֵ
	 * @return
	 */
	private AVLTreeNode<T> insert(AVLTreeNode<T> node, T key) {
		if(node==null){//�½ڵ�
			node=new AVLTreeNode<T>(key,null,null);
		}else{//���ڸ����ҽڵ�
			int cmp=key.compareTo(node.key);
			
			if(cmp<0){
				node.left=insert(node.left,key);
				if(height(node.left)-height(node.right)==2){//����ƽ�⣬��Ҫ��ת��������������
					if(key.compareTo(node.left.key)<0){
						node=this.ll(node);
					}else{
						node=this.lr(node);
					}
					
				}
			}else if(cmp>0){
				node.right=insert(node.right,key);
				if(height(node.right)-height(node.left)==2){//����ƽ��
					if(key.compareTo(node.right.key)>0){
						node =this.rr(node);
					}else{
						node=this.rl(node);
					}
					
				}
			}else{
				System.out.println("���ܴ���������");
			}
			
		}
		node.height=this.max(height(node.left), height(node.right))+1;
		return node;
	}
	public void insert(T key) {
		mRoot = insert(mRoot, key);
	}
	/*
	 * ��ӡ"���������"
	 *
	 * key        -- �ڵ�ļ�ֵ 
	 * direction  --  0����ʾ�ýڵ��Ǹ��ڵ�;
	 *               -1����ʾ�ýڵ������ĸ���������;
	 *                1����ʾ�ýڵ������ĸ������Һ��ӡ�
	 */
	private void print(AVLTreeNode<T> tree, T key, int direction) {
		if(tree != null) {
			if(direction==0)    // tree�Ǹ��ڵ�
				System.out.printf("%2d is root\n", tree.key, key);
			else                // tree�Ƿ�֧�ڵ�
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

		System.out.printf("== �������: ");
		for(i=0; i<arr.length; i++) {			
			//tree.insert(arr[i]);
			tree.mRoot=tree.insert(tree.mRoot,arr[i]);
			System.out.printf("%d ", arr[i]);
		}
		System.out.printf("\n== ǰ�����: ");
		tree.preOrder();
		System.out.printf("\n== �������: ");
		tree.inOrder();
		System.out.printf("\n== �������: ");
		tree.postOrder();
		System.out.printf("\n");
		System.out.printf("== �߶�: %d\n", tree.height());
		
		System.out.printf("== ������ϸ��Ϣ: \n");
		tree.print();


		
	}
}
