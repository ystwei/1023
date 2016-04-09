<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.weikun.service.*,com.weikun.vo.*"%>
<%
	request.setCharacterEncoding("utf-8");
	String username=request.getParameter("username");
	String pwd=request.getParameter("pwd");
	
	IUserService service=new UserServiceImpl();
	MyUser user=new MyUser();
	user.setPwd(pwd);
	user.setUsername(username);

	if(service.login(user)){//true :success false:error
		session.setAttribute("username", username);
		response.sendRedirect("success.jsp");
	}else{
		response.sendRedirect("error.jsp");
	}
	
%>