package com.xijinping;

public class E {
	public static void main(String[] args) {
		int i=200;
		assert i==100:"����100ʧ�ܣ��˱��ʽ����Ϣ�������׳��쳣��ʱ�������";
        System.out.println("����1û�����⣬Go��");
 
        System.out.println("\n-----------------\n");
 
        //����2���Ϊfalse,������ֹ
        assert i==200 : "����ʧ�ܣ��˱��ʽ����Ϣ�������׳��쳣��ʱ�������";
        System.out.println("����2û�����⣬Go��");
	}
}
