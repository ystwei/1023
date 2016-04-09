<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=
		pageContext.getAttribute("key2")
	%>
	<%=
		request.getAttribute("key3")
	%>
	<%=
		request.getAttribute("key4")
	%>
	
	<%=
			pageContext.getAttribute("key4", PageContext.REQUEST_SCOPE)
	%>
		
			
	
	<%=
		session.getAttribute("key5")
	%>
	
	<%=pageContext.getAttribute("key5", PageContext.SESSION_SCOPE)
	%>
	
	<%=
		application.getAttribute("key6")
	%>
	<%=pageContext.getAttribute("key6", PageContext.APPLICATION_SCOPE)
	%>
</body>
</html>