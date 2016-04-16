<%@ page language="java" import="java.util.*,com.weikun.vo.*"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<link href="css/MessageCss.css" type=text/css
			rel=stylesheet>
		<title>显示留言</title>
	</head>
	<body>
		<p align="center"></p>
		<hr>
		
		<h2 align="center">
			访客留言
		</h2>
		<c:forEach items="${requestScope.list}" var="mes" varStatus="status">
		<table width="951" border="1" align="center" height="141"
			bordercolor="99ccff" cellpadding="0" cellspacing="0">
			<tbody>
				<tr>
					<td bgcolor="#ffff80">
						主题
					</td>
					<td colspan="3">
						${mes.title}
					</td>
				</tr>
				<tr>
					<td bgcolor="#ffff80">
						留言人
					</td>
					<td>
						${mes.name}
					</td>
					<td bgcolor="#ffff80">
						Email
					</td>
					<td valign="top">
						${mes.email}
					</td>
				</tr>
				<tr>
					<td bgcolor="#ffff80">
						留言时间
					</td>
					<td colspan="3">
						${mes.date}
					</td>
				</tr>
				<tr>
					<td valign="top" bgcolor="#ffff80">
						留言内容
					</td>
					<td valign="top" colspan="3">
						${mes.content}
					</td>
					
				</tr>
				<tr>
					<td valign="top" colspan="4">
						第${status.count}条记录
					</td>
					
				</tr>
				<tr>
					<td valign="top" colspan="4">
						<a href="message?action=del&id=${mes.id}">删除</a>
					</td>
				</tr>
			</tbody>
		</table>
	
		</c:forEach>
		<p align="center">
			<a href="message.jsp">我要留言</a>
		</p>

	</body>
</html>
