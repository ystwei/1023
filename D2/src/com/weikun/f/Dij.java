package com.weikun.f;

import java.util.Stack;

public class Dij {//dj˹�ؿ���˫ջ�㷨������ʽ���ұ��ʽ�����Ű�
	//2+3*5=(2+(3*5))
	
	public static void main(String[] args) {
		String s="((2+(2*3))+(1-2))";
		System.out.println(evl(s));
	}
	public static double evl(String bds){
		Stack<Character> op=new Stack<Character>();//�����ջ
		Stack<Double> czs=new Stack<Double>();//������ջ
		
		char[] cc=bds.toCharArray();
		
		for(int i=0;i<cc.length;i++){
			if(cc[i]=='+'){
				op.push(cc[i]);
			}else if(cc[i]=='-'){
				op.push(cc[i]);
			}else if(cc[i]=='*'){
				op.push(cc[i]);
			}else if(cc[i]=='/'){
				op.push(cc[i]);
			}else if(cc[i]=='('){
				
			}else if(cc[i]==')'){
				//�ÿ�ʼ������
				//��������
				
				char o=op.pop();
				double d=czs.pop();
				if(o=='+'){
					d=d+czs.pop();
				}else if(o=='-'){
					d=czs.pop()-d;//ΪɶҪ�ߵ�
				}else if(o=='*'){
					d=d*czs.pop();
				}else if(o=='-'){
					d=czs.pop()/d;
				}
				czs.push(d);
				
				
			}else{//�����˲�����
				czs.push(Double.parseDouble(Character.toString(cc[i])));
			}		
			
		}
		
		
		
		return czs.pop();
	}

}
