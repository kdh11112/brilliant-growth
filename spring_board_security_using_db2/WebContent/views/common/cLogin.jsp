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
	<h2>cLogin</h2>
	<h2>
		<c:out value="${error }"/>
	</h2>
	<h2>
		<c:out value="${logout }"/>
	</h2>
	<!-- 
		CSRF(Cross Site Request forgery) 불특정 다수를 대상으로 로그인된 사용자가자신의 의지와는 무관하게 공격자가 의도한 행위를 하게 만드는 공격방법
	 -->
	
	<!-- <form action="/spring_board01/login" method="post"> -->
	<form action="<c:url value='/login'/>" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="username" id="" value="user"/></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="text" name="password" id="" value="123"/></td>
				<td><input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>