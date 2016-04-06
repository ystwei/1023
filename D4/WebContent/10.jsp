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
		String count=application.getInitParameter("count");
		
	
	%>
	
	<%
		if(application.getAttribute("num")==null){//第一次访问
			application.setAttribute("num", count);
		}else{
			
			String num=application.getAttribute("num").toString();
			
			application.setAttribute("num", Integer.parseInt(num)+1);		
			
		}
	
	%>
	你是第<h1><%=application.getAttribute("num") %>
	</h1>访客
	
</body>
</html>