<%@ page language="java" contentType="text/html; charset=utf-8" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
			request.setAttribute("key", 999);
	%>
	<form name="form1" id="form1" action="5.jsp" method="post">
		用户名<input type="text" name="username" id="username"/>
		<input type="submit" value="提交">
		
	</form>
</body>
</html>