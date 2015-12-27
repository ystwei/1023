/**
 * 
 */
package com.weikun.dyproxy;

import java.lang.reflect.Proxy;

/**
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		
		IAnimal c=new Cat();
		MyProxy my=new MyProxy(c);
		Object o=Proxy.newProxyInstance(c.getClass().getClassLoader(), 
				c.getClass().getInterfaces(), my);
		
		IAnimal a=(IAnimal)o;
		a.eat();
		a.drink();
		
		
	}
}
