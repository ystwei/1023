<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	function ok(){
		
		var username=document.getElementById("username").value;
		var pwd=document.getElementById("pwd").value;
		
		if(username=="" || pwd==""){
			
			alert('用户名或密码为空，不能继续！');
			return ;
		}
		//是否存储到cookie
		if(document.getElementById("sun").checked){
			//删除cookie
			var Days = 7; 
		    var exp = new Date(); 
		    exp.setTime(exp.getTime() + Days*24*60*60*1000); 	
		    document.cookie = " username="+ username +" ,password="+pwd+" ;expires=" + exp.toGMTString(); 
		}
		document.all.form1.submit();
	}
	function del(){
	    var exp = new Date();
	    exp.setTime(exp.getTime() - 1);
	    var cval=getCookie("username");
	    var cval1=getCookie("password");
	    document.cookie= "username="+cval+";expires="+exp.toGMTString();
	    document.cookie= "password="+cval1+";expires="+exp.toGMTString();
		
	}
	//取cookies函数 
	function getCookie(name){ 
		
	    var arr=document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)")); 
	    if(arr!=null){ 
	        return unescape(arr[2]); 
	    } 
	    return null; 
	} 
</script>
</head>
<body>
	<h1>登录我的系统--milestone</h1>
	
	<form action="checkuser.jsp" id="form1" name="form1">
		用户名：<input type="text" id="username" name="username"/><br/>
		密码：<input type="text" id="pwd" name="pwd"/><br/>
		<input type="checkbox" id="sun"/>是否记住密码(7天)
		<input type="button" value="提交" onclick="ok()"/>
	</form>
		<input type="button" value="删除" onclick="del()"/>
	<script type="text/javascript">
		document.write(document.cookie);
		document.write(document.cookie.split(",")[0].split(";")[1]);
		var username =document.cookie.split(",")[0].split("=")[1];
		var password =document.cookie.split(";")[0].split(",")[1].split("=")[1];
		document.all.form1.username.value=username;
		document.all.form1.pwd.value=password;
		document.all.form1.sun.checked=true;
	</script>
</body>
</html>