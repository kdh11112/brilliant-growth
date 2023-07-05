<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>home.jsp</h2>
	
	<sec:authorize access="isAuthenticated()">
		<a href="<c:url value='logout'/>">로그아웃기본페이지</a>
		
		<a href="<c:url value='common/cLogout'/>">로그아웃</a>
	</sec:authorize>
	
	<ul>
		<li><a href="board/list">게시판</a></li>
		<li><a href="member/member">회원</a></li>
		<li><a href="admin/admin">관리자</a></li>
		<li><a href="public/public">일반용</a></li>
		<li><a href="common/cLogin">커스텀로그인페이지</a></li>
		<li><a href="common/cLogout">커스텀로그인페이지</a></li>
	</ul>
</body>
</html>