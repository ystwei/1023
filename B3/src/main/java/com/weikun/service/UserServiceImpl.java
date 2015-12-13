package com.weikun.service;

public class UserServiceImpl {
	public boolean login(String username,String pwd){
		
		
		if(username.equals("weikun")&&pwd.equals("119")){
			
			return true;
		}else{
			return false;
		}
	}
}
