package com.weikun.sort;

public class B {//堆排序

	private static int [] data={9,79,46,30,58,49};
	public static void main(String[] args) {
		
		
		for(int i=0;i<data.length-1;i++){
			build(data.length-1-i);//已经交换完毕，且最大值在0号索引
			
			
			
			swap(0,data.length-1-i);
			
		}
		
		for(int i:data){
			
			System.out.println(i);
		}
		
		
	}
	//构建大顶堆
	public static  void build(int lastIndex){
		/*
		 *        9
		 *      /   \
		 *    79    46
		 *   / \   /
		 * 30  58 49 
		 */
		
		for(int i=(lastIndex-1)/2;i>=0;i--){
			int k=i;
			while(k*2+1<=lastIndex){//判断49这个值，它的索引号是否在有效范围内
				int bigIndex=k*2+1;
				if(bigIndex<lastIndex){//就证明data[i]还有右子节点
					if(data[bigIndex]-data[bigIndex+1]<0){//证明右节点值大
						bigIndex++;
					}
				}
				//bigIndex:是数比较大的节点索引,在跟父亲比
				if(data[k]-data[bigIndex]<0){//父亲比他小，根据大顶堆的定义，父亲比两儿子都要大
					//把大的值给父亲
					swap(k,bigIndex);
				}else{
					break;
				}
				
			}
			
		}
	}
	public static void swap(int min,int max){
		int tmp=0;
		tmp=data[min];
		data[min]=data[max];
		data[max]=tmp;
		
	}
	
}
