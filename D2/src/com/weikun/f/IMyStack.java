package com.weikun.f;

public interface IMyStack {	  
	    /** 
	     * 判断栈是否为空 
	     */  
	    boolean isEmpty();  
	    /** 
	     * 清空栈 
	     */  
	    void clear();  
	    /** 
	     * 栈的长度 
	     */  
	    int length();  
	    /** 
	     * 数据入栈 
	     */  
	    boolean push(Object data);  
	    /** 
	     * 数据出栈 
	     */  
	     //返回栈顶元素，删除栈顶元素
	    Object pop();  
	    //返回栈顶元素，但不删除栈顶元素
	    Object peek();  
	 
}
