package com.weikun.tree;

public class TestArrayBin {
	 /* 
	 *      A
	 *       \
	 *        B
	 *       /  
	 *      C
	 *       \
	 *        D
	 * 
	 */
	public static void main(String[] args) {
		ArrayBin bin=new ArrayBin(8,"A");
		bin.add(0, "B",false );
		bin.add(2, "C",true );
		bin.add(5, "D",false );
		
		System.out.println(bin.left(2));
		//System.out.println(bin.right(1));
	}
}
class ArrayBin{
	private Object[] datas;	
	//保存该树的深度
	private int deep=8;
	private int arraySize;//二叉树总节点的个数
	//以默认的深度来创建二叉树
	ArrayBin(){

		this.arraySize=(int)Math.pow(2, this.deep)-1;//总共节点个数

		datas=new Object[this.arraySize];//开辟空间


	}

	ArrayBin(int deep){
		this.deep=deep;
		this.arraySize=(int)Math.pow(2, this.deep)-1;//总共节点个数

		datas=new Object[this.arraySize];//开辟空间


	}
	
	
	ArrayBin(int deep,String data){
		this.deep=deep;
		this.arraySize=(int)Math.pow(2, this.deep)-1;//总共节点个数

		datas=new Object[this.arraySize];//开辟空间
		datas[0]=data;


	}
	/**
	 * 
	 * @param parentIndex:父节点的索引
	 * @param data：当前节点数据
	 * @param left：是否为做
	 */
	public void add(int parentIndex,String data,boolean left){
		if(datas[parentIndex] ==null){
			System.out.println("你爹还不存在哪");
			return ;
		}
		if(2*parentIndex+1>=this.arraySize){//
			System.out.println("数组已经满了");
			return ;
		}
		if(left){//如果是添加parentIndex节点的左子节点
			datas[2*parentIndex+1]=data;

		}else{//右子节点
			datas[2*parentIndex+2]=data;
		}


	}
	//返回当前节点的左子节点
	public Object left(int parentIndex){
		
		if(this.arraySize<2*parentIndex+1){
			System.out.println("没有左子");
			return null;
		}
		return datas[2*parentIndex+1];
		
	}

	//返回当前节点的右子节点
	public Object right(int parentIndex){
		if(this.arraySize<2*parentIndex+2){
			System.out.println("没有右子");
			return null;
		}
		return datas[2*parentIndex+2];
	}


}
