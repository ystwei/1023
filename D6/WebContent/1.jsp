<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:set var="count" value="100" scope="page"></c:set>
	${count}<!-- el jstl -->
	page:${pageScope.count}
	session:${sessionScope.count}
	request:${requestScope.count}
	application:${applicationScope.count}
	session:<%=pageContext.getSession().getAttribute("count")%>
	page:<%=pageContext.getAttribute("count")%>
</body>
</html>