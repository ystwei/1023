<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function test(){
		if(document.getElementById("name1").value==""){			
			alert("你必须输入用户名！");
			return ;			
		}	
		var c=document.getElementsByName("color");
		var flag=false;
		for(var i=0;i<c.length;i++){			
			if(c[i].checked){
				flag=true;
				break;
			}
		}		
		if(flag==true){
			document.all.form1.submit();
		}else{
			alert("你必须选择颜色！");
		}
	}
</script>
</head>
<body>
	<form id="form1" name="form1" action="8.jsp" method="get">
		<input type="text" name="username" id="name1"/>
		
		<input type="checkbox" name="color" value="red"> 红色
		<input type="checkbox" name="color" value="green"> 绿色
		<input type="checkbox" name="color" value="yellow">黄色
		<input type="button" value="提交" onclick="test()"/>
	</form>
	<%	
		session.setAttribute("key1", 888);
		session.setAttribute("key", 999);
	%>
	<a href="9.jsp">点击</a>
</body>
</html>