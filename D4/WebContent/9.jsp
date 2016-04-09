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
		
		pageContext.getRequest().setAttribute("key4", "ok4");//reqeust
		
		
		pageContext.getSession().setAttribute("key5", "ok5");//session
		
		pageContext.getServletContext().setAttribute("key6", "ok6");//application
	
		request.setAttribute("key3", "ok3");
	
	%>

	jsp:<jsp:include page="91.jsp"></jsp:include>
	
</body>
</html>