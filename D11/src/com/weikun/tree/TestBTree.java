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

		System.out.print("== �������: ");
		ilen = arr.length;
		for(i=0; i<ilen; i++) {
			System.out.print(arr[i]+" ");
			tree.insert(arr[i]);
		}
		System.out.print("\n== ǰ�����DLR: ");
		tree.preOrder();

		System.out.print("\n== �������LDR: ");
		tree.inOrder();

		System.out.print("\n== �������LRD: ");
		tree.postOrder();
		System.out.println();

		
		
		System.out.println("== ������ϸ��Ϣ: ");
		tree.print();

		System.out.print("\n== ɾ���ڵ�: "+ arr[5]);
		tree.remove(arr[5]);

		System.out.print("\n== �������: ");
		tree.inOrder();
		System.out.println();

	
	}
	
	
}
class BSTree {
	BSTreeNode root;//���ڵ�
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

	/*�ݹ�ʵ�֣����Ҷ�����x�м�ֵΪkey�Ľڵ�
	 * 
	 */
	private BSTreeNode search(BSTreeNode x,Integer key){
		if(x==null){
			return x;
		}
		int cmp=key.compareTo(x.key);
		if(cmp<0){//С�ڵ�ǰ�ڵ��ֵ�����������в�
			return search(x.left,key);
		}else if(cmp>0){//���ڵ�ǰ�ڵ��ֵ�����������в�
			return search(x.right,key);
		}else{
			return x;
		}		
	}
	//ǰ�����DLR
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
	//������� LDR
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
	//������� LRD
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
	public BSTreeNode max(BSTreeNode node){// ��������㣬����treeΪ���ڵ�Ķ����������ڵ㣬���Ҳ���
		if(node==null){
			return null;
		}
		while(node.right!=null){
			node=node.right;
			
		}
		return node;
	}
	
	public BSTreeNode min(BSTreeNode node){// ������С��㣬����treeΪ���ڵ�Ķ���������С�ڵ㣬�������
		if(node==null){
			return null;
		}
		while(node.left!=null){
			node=node.left;
			
		}
		return node;
	}
	
	/*��̽ڵ�
	 * �ҽ��x�ĺ�̽ڵ㣬�������Ҷ�����������ֵ���ڸýڵ����С�ڵ�
	 */
	public BSTreeNode successor(BSTreeNode x){
		if(x.right!=null){//������
			return this.min(x.right);
		}
		
		if(x.parent==null){
			System.out.println("û�к��");
			return null;
		}
		BSTreeNode y=x.parent;//���ҵ��丸��
		//û��������
		//2a:x��һ�����ӣ���ôx�ĺ�̾����丸��
		//2b:x��һ���Һ��ӣ���ôx�ĺ�����丸�׵ĸ��ף��ҵ�һ�����׵�����
		
		while(y!=null && x==y.right){
			
			x=y;
			y=y.parent;
					
		}
		return y;
	}
	public void insert(Integer key){
		BSTreeNode z=new BSTreeNode(key,null,null,null);
		//����½��ڵ�ʧ�ܣ��򷵻�
		if(z!=null){
			insert(this,z);
		}
	}
	/* ���ڵ���뵽��������
	 * tree��������
	 * z������Ľڵ� */	
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
				System.out.println("�ڵ�ֵ�ظ�");
				return;
			}
			
		}
		z.parent=y;//Ҫ�ӵ���ǰ�ڵ�Ķ����ϣ�y����������
		if(y==null){//û�и���,���ڸ���
			tree.root=z;
			
		}else {
			if(z.compareTo(y)>0){
				y.right=z;
			}else if(z.compareTo(y)<0){
				y.left=z;
			}else{
				System.out.println("�ڵ�ֵ�ظ�");
				return;
			}
		}
				
		
	
	}
	
	/*
	 * ɾ���ڵ�z�������ر�ɾ���Ľڵ�
	 * bst��������
	 * zɾ���Ľڵ�
	 * 1.û�ж��ӣ���ΪҶ��㡣ֱ�ӰѸ����Ķ�Ӧ����ָ����ΪNULL����OK�ˡ�
	   2.ֻ��һ�����ӡ���ô�Ѹ�������Ӧ����ָ��ָ����ӵĶ����ӣ�ɾ�����ӽ��ҲOK�ˡ�
	   3.���������ӡ��������鷳���������Ϊ��ɾ���ڵ�֮�󣬻�Ҫ��֤���������������Ľṹ����ʵҲ�Ƚ����ף�
	   ���ǿ���ѡ��������е����Ԫ�ػ����Ҷ����е���СԪ�طŵ���ɾ���ڵ��λ�ã��Ϳ��Ա�֤�ṹ�Ĳ��䡣
	   ��Ȼ����Ҫ�ǵõ����������Ͼ��ֳ����˽ڵ�ɾ����ϰ���ϴ��ѡ��������е����Ԫ�أ���ʵѡ���Ҷ��ӵ���СԪ��Ҳһ����
	   û���κβ��ֻ������ϰ�ߴ������ҡ���������Ҳѡ������ӵ����Ԫ�أ������ŵ���ɾ����λ�á�
	   ����ӵ����Ԫ����ʵ�ܺ��ң�ֻҪ˳������Ӳ��ϵ�ȥ�����������Ϳ����ˣ�ֱ���ҵ�һ��û���������Ľ�㡣�Ǿ��������ˡ�
	 */
	private BSTreeNode remove(BSTree tree,BSTreeNode z){
		BSTreeNode x=null;
		BSTreeNode y=null;
		
		if(z.left==null||z.right==null){//��û���� ��û����
			y=z;
		}else{//�����������ң��ҵ����̽ڵ�
			
			y=this.successor(z);
		}
		
		//�ҵ����̽ڵ�����ӻ�������
		if(y.left!=null){
			x=y.left;
		}else{
			x=y.right;
		}
		if(x!=null){//������ֵ
			x.parent=y.parent;
		}
		
		//�Ѻ�̽ڵ�ٳ�ȥ���ڰ���ԭ�е�����������Ū��ȥ
		
		if(y.parent==null){
			tree.root=x;
		}else if(y==y.parent.left){
			y.parent.left=x;//�Ѻ�̵���������ȥ
		}else{
			
			y.parent.right=x;//�Ѻ�̵���������ȥ
		}		
		
		if(y!=z){
			z.key=y.key;
		}
		return y;
	}
	
	//�ҵ�x��ǰ���ڵ㣺/���Ҹýڵ�(x)��ǰ���ڵ㣬�����Ҷ�����������ֵС�ڸýڵ�����ڵ�
	public BSTreeNode predecessor(BSTreeNode x){
		if(x.left!=null){//������
			return this.max(x.left);
		}
		//û��������
		//2a:x��һ���Һ��ӣ���ôx��ǰ�������丸��
		if(x.parent==null){
			System.out.println("û��ǰ��");
			return null;
		}
		BSTreeNode y=x.parent;//���ҵ��丸��
		
		//2b:x��һ�����ӣ���ôx��ǰ�����丸�׵ĸ��ף��ҵ�һ�����׵�����
		
		while(y!=null && x==y.left){
			
			x=y;
			y=y.parent;
					
		}
		return y;
		
		
	}
	/*
	 * ��ӡ"���������"
	 *
	 * key        -- �ڵ�ļ�ֵ 
	 * direction  --  0����ʾ�ýڵ��Ǹ��ڵ�;
	 *               -1����ʾ�ýڵ������ĸ���������;
	 *                1����ʾ�ýڵ������ĸ������Һ��ӡ�
	 */
	private void print(BSTreeNode tree, Integer key, int direction) {

		if(tree != null) {

			if(direction==0)  {  // tree�Ǹ��ڵ�
				System.out.printf("%2d is root\n", tree.key);
			}else{                // tree�Ƿ�֧�ڵ�
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
	 * ɾ���ڵ�z�������ر�ɾ���Ľڵ�
	 * tree���������ĸ��ڵ�
	 * z ɾ���Ľڵ�
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