package com.weikun.dyproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyProxy implements InvocationHandler {
	private Object obj;
	public MyProxy(Object obj){
		this.obj=obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("����ִ�аɣ�");
		System.out.println("�ĸ�������������:"+method.getName());		
		return method.invoke(this.obj, args);
	}

}
