package com.weikun.command;

public class Invoker {
	public void  getMessage(Command cmd){
		cmd.execute();		
	}
}
