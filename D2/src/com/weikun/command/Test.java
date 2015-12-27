package com.weikun.command;

public class Test {
	public static void main(String[] args) {
		Receiver rece=new Receiver();
		ConcreteCommand cmd=new ConcreteCommand(rece);
		
		Invoker in=new Invoker();
		in.getMessage(cmd);
		
	}
}
