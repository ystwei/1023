<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
		request.setCharacterEncoding("utf-8");
	%>
	<%
		String username=request.getParameter("username");
		String [] names={"weikun","mike"};
		boolean flag=false;
		for(String s :names){
			
			if(s.equals(username)){
				flag=true;
				break;
			}
			
		}
		if(flag){
			
	%>
		<script type="text/javascript">
			//跳转
			//window.location="success.jsp?pwd=119";
			
		</script>
		<!-- 转向 -->
 		<jsp:forward page="success.jsp"> 
			<jsp:param value="密码" name="pwd"/> 
		
		</jsp:forward> 
	
	<%
	
		}
		request.getAttribute("key");
		//request.setAttribute("key", 999);//含义就是对容器的内存进行操作
	%>
	
	<a href="6.jsp?name=119">点击</a>
</body>
</html>