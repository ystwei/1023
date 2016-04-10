<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="ani" class="com.weikun.vo.Animal"></jsp:useBean>
	<jsp:setProperty property="name" name="ani" value="猫"/>
	
	动物名字:${ani.name}
	动物名字:${ani["name"]}
	动物名字:<jsp:getProperty property="name" name="ani"/>
	动物名字:<%=ani.getName() %>
	
	<jsp:setProperty property="name" name="ani" value="狗"/>
	
	${ani.dog.red}
	${ani["dog"].red}
	${ani.dog["red"]}
	<%=ani.getDog().get("green") %>
	
	<jsp:setProperty property="name" name="ani" value="猪"/>
	${ani.pig[0]}

	<%=ani.getPig().get(0) %>
	
	
	<jsp:setProperty property="name" name="ani" value="鸭"/>
	${ani.duck[0]}

	<%=ani.getDuck()[0] %>
	
	<a href="3.jsp?pwd=999&pwd=111">点击</a>
</body>
</html>