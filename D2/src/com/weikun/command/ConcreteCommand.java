package com.weikun.command;

public class ConcreteCommand implements Command {
	private Receiver rece;
	public ConcreteCommand(Receiver rece){
		this.rece=rece;
		
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.rece.action();
	}

}
