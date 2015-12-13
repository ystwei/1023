package com.weikun.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.weikun.service.UserServiceImpl;

@ParentPackage(value="struts-default")
@Namespace(value="/")
//@Actions({
//	
//	@Action(value="user2",results={
//			@Result(name="success",location="/success.jsp"),
//			@Result(name="index",location="/index.jsp")
//	}),
//	@Action(value="user3",results={
//			@Result(name="success",location="/success.jsp"),
//			@Result(name="index",location="/index.jsp")
//	})
//	
//})
@Results({
	
	@Result(name="success",location="/success.jsp"),
	@Result(name="index",location="/index.jsp")
})

public class UserAction extends ActionSupport {
	private UserServiceImpl service=new UserServiceImpl();
	private HttpServletRequest request=ServletActionContext.getRequest();
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
	
		String pwd=request.getParameter("pwd").toString();
	
		
		if(service.login(username, pwd)){
			request.setAttribute("username", username);
			return "success";
		}else{
			return "index";
		}
		
	}
	
	
}
