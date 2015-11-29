package com.weikun.d;

import java.util.Arrays;

public class K {
	public static void main(String[] args) {
		int []a={2,1,3,4,5};
		
		//��������
		Student [] ss={new Student("gou","��",90),
					   new Student("mao","è",100),
					   new Student("zhu","��",100)};
		
		Arrays.sort(ss);
		System.out.println(Arrays.binarySearch(ss, new Student("mao","è",100)));
		
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
	public int compareTo(Object o) {//�Ƚϵ�
		// TODO Auto-generated method stub
		//��student��������ȵ�����£�����������
		Student that=(Student)o;return this.old==that.old?this.pinyin.compareTo(that.pinyin):this.old-that.old;
		
	}
	
}