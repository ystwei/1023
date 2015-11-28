package com.weikun.d;
import java.util.*;
public class J {
	//随机生成元素，存数组的元素必须不同的三种写法
	public void ok2(){
		char a[]=new char[10];
		char r='a';
		for(int i=0;i<a.length;){
			r=(char)(Math.random()*26+65);
			int f=0;
			for(int j=0;j<i;j++){
				if(r==a[j]){
					f=1;
					break;
				}else{
					f=0;
				}
			}
			if(f==0){
				a[i]=r;
				i++;
			}
		}
		for(char i:a){
			System.out.print(i);
		}
	}
	
	
	public  void ok1() {
		int []a = new int[100];
		for(int i=0;i<10;){
			int x = (int)(Math.random()*26+65);
			if(a[x] == 0){
				System.out.println((char)(x));
				a[x] = 1;
				i++;
			}
		}
	
	}
	public static void main(String[] args) {
		new J().ok3();
	}
	public void ok3(){
		char []a=new char[10];		
		for(int i=0;i<a.length;i++){
			char r=(char)(Math.random()*26+65);
			a[i]=different(a,r,i);
		}
		Arrays.sort(a);
		for(char e:a){
			System.out.println(e);
		}
	}
	private char different(char[] a, char r,int j) {
		// TODO Auto-generated method stub	
		for(int i=0;i<j;i++){
			if(r==a[i]){				
				r=(char)(Math.random()*26+65);
				i=0;//一旦相同，重头开始比较
				different(a,r,j);								
			}
		}		
		return r;		
	}
	
	
	
	
	
	
	
	
	
	

		

	
}
