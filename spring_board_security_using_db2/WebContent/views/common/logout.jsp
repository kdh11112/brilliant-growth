<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>커스텀 로그아웃 페이지 : logout.jsp</h2>
	
	<c:url value="/common/cLogout"/>
	
	<form action="<c:url value='/common/cLogout'/>" method="post">
		<input type="hidden" name="${_csrf.parameterName }" id="" value="${_csrf.token }"/>
		<input type="submit" value="로그아웃"/>
	</form>
	
</body>
</html>