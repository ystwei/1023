 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
    
<div class="pagination">
	<ul>
		<c:if test="${pb.curPage!=1}">
			<li><a href="article?action=query&page=1">首页</a></li>
		</c:if>
		<c:if test="${pb.curPage==1}">
			<li><a href="#">首页</a></li>
		</c:if>
		<li><a href="article?action=query&page=${pb.curPage-1}">前一页</a></li>
		
			
			<c:forEach begin="1" end="${pb.maxPage}" step="1" var="p">		
				<li><a href="article?action=query&page=${p}">${p}</a></li>
			</c:forEach>
		
		
		
			<li><a href="article?action=query&page=${pb.curPage+1}">下一页</a></li>
		
		
		
		<c:if test="${pb.curPage!=pb.maxPage}">
			<li><a href="article?action=query&page=${pb.maxPage}">尾页</a></li>
		</c:if>
		<c:if test="${pb.curPage==pb.maxPage}">
			<li><a href="#">尾页</a></li>
		</c:if>
	</ul>
</div>