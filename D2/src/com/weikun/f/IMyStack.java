package com.weikun.f;

public interface IMyStack {	  
	    /** 
	     * �ж�ջ�Ƿ�Ϊ�� 
	     */  
	    boolean isEmpty();  
	    /** 
	     * ���ջ 
	     */  
	    void clear();  
	    /** 
	     * ջ�ĳ��� 
	     */  
	    int length();  
	    /** 
	     * ������ջ 
	     */  
	    boolean push(Object data);  
	    /** 
	     * ���ݳ�ջ 
	     */  
	     //����ջ��Ԫ�أ�ɾ��ջ��Ԫ��
	    Object pop();  
	    //����ջ��Ԫ�أ�����ɾ��ջ��Ԫ��
	    Object peek();  
	 
}
