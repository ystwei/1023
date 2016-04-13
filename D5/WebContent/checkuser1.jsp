<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:requestEncoding value="utf-8"/>
<c:set var="username" value="${param.username}"></c:set>
<c:set var="pwd" value="${param.pwd}"></c:set>
<jsp:useBean id="service" class="com.weikun.service.UserServiceImpl"></jsp:useBean>
<jsp:useBean id="user" class="com.weikun.vo.MyUser"></jsp:useBean>
<jsp:setProperty property="pwd" name="user" value="${pwd}"/>
<jsp:setProperty property="username" name="user" value="${username}"/>

<c:if test="${service.login(user)}">
	<c:set scope="session" var="username" value="${username}"></c:set>
	<c:redirect url="success.jsp"></c:redirect>

</c:if>
<c:if test="${!service.login(user)}">
	<c:redirect url="error.jsp"></c:redirect>
</c:if>
