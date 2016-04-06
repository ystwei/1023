<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//session.removeAttribute("key1");
		//session.invalidate();
	%>
	<%//session.getAttribute("key")
	%>
	
	<%
		pageContext.setAttribute("key2", "ok");//page
	
	%>
	
	<%@include file="91.jsp" %>
	
</body>
</html>