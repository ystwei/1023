package com.weikun.h;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.weikun.Animal.Animal;

public class A {
	public static void main(String[] args) {//reflect
		String s1="org.weikun.Animal.Animal";
		try {
			
			Class<?>  c=Class.forName(s1);// ��  ����ʱ�� ����
			
			Object a=c.newInstance();//������
			
			
			
			Field name=c.getDeclaredField("name");
			name.setAccessible(true);
			name.set(a, "����");
			System.out.println(name.get(a));
			
			//Field []fs=c.getFields();
			//Field fs[]=c.getDeclaredFields();
			
//			for(Field f :fs){
//				System.out.println(f.getName());
//			}
			
			//Constructor c1=c.getConstructor(String.class,int.class);
			
			//Object o=c1.newInstance("��",10);
			//��������
			
//			Method s=c.getMethod("setName",String.class);
//			s.invoke(a, "��");
//			Method g=c.getMethod("getName");
//			System.out.println(g.invoke(a));
			
			
			//Method []ms=c.getMethods();
			
//			for(Method m :ms){
//				System.out.println(m.getName());
//			}
			//System.out.println(a.getName());
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
