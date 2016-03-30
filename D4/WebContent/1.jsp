<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#s{
		color:red;
	}
	#s1{
		color:blue;
	}

</style>
</head>
<body>
	
	<%   for(int i=0;i<10;i++){ 
			
		  
		
			if(i%2==0){				
	%>		
				<span id="s">
					<%=i%>
				</span>	
				<br/>
			<%}else{ %>
				<span id="s1">
					<%=i %>
				</span>
				<br/>
	    	<%
			 }
		    } %>
	
</body>
</html>