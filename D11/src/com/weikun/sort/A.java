package com.weikun.sort;

public class A {
	public static void main(String[] args) {
		new A().zjSort();
	}
	
	public void zjSort(){//÷±Ω”≈≈–Ú
		
		int a[]={4,3,2,1,8,9,5};
		for(int i=0;i<a.length-1;i++){
			
			
			for(int j=i+1;j<a.length;j++){
				
				if(a[i]-a[j]>0){
					int tmp=a[i];
					a[i]=a[j];
					a[j]=tmp;
				}
				
				
			}
		}
		for(int i : a){
			System.out.println(i);
		}
		
	}
}
