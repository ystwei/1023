<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String s=request.getParameter("user")+"你好!";
	String s1=request.getParameter("pwd")+"密码!";
	out.print(s+s1);
%>