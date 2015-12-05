package com.weikun.f;

import java.util.Stack;

public class Dij {//dj斯特卡拉双栈算法，算表达式，且表达式用括号包
	//2+3*5=(2+(3*5))
	
	public static void main(String[] args) {
		String s="((2+(2*3))+(1-2))";
		System.out.println(evl(s));
	}
	public static double evl(String bds){
		Stack<Character> op=new Stack<Character>();//运算符栈
		Stack<Double> czs=new Stack<Double>();//操作数栈
		
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
				//得开始运算了
				//倒出来数
				
				char o=op.pop();
				double d=czs.pop();
				if(o=='+'){
					d=d+czs.pop();
				}else if(o=='-'){
					d=czs.pop()-d;//为啥要颠倒
				}else if(o=='*'){
					d=d*czs.pop();
				}else if(o=='-'){
					d=czs.pop()/d;
				}
				czs.push(d);
				
				
			}else{//发现了操作数
				czs.push(Double.parseDouble(Character.toString(cc[i])));
			}		
			
		}
		
		
		
		return czs.pop();
	}

}
