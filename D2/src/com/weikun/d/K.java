package com.weikun.d;

import java.util.Arrays;

public class K {
	public static void main(String[] args) {
		int []a={2,1,3,4,5};
		
		//对象数组
		Student [] ss={new Student("gou","狗",90),
					   new Student("mao","猫",100),
					   new Student("zhu","猪",100)};
		
		Arrays.sort(ss);
		System.out.println(Arrays.binarySearch(ss, new Student("mao","猫",100)));
		
		for(Student  i :ss){
			
			System.out.println(i.getName());
		}
		
	}
}
class Student implements Comparable{
	
	public Student(String pinyin,String name, int old) {
		super();
		this.pinyin=pinyin;
		this.name = name;
		this.old = old;
	}
	private String pinyin;
	private String name;
	private int old;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOld() {
		return old;
	}
	public void setOld(int old) {
		this.old = old;
	}
	@Override
	public int compareTo(Object o) {//比较的
		// TODO Auto-generated method stub
		//在student的年龄相等的情况下，在排序名字
		Student that=(Student)o;return this.old==that.old?this.pinyin.compareTo(that.pinyin):this.old-that.old;
		
	}
	
}