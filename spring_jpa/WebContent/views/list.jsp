<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
	<h2>list.jsp</h2>
	
	<ul>
		<li><a href="list">목록보기</a></li>
		<li><a href="addData">데이터 추가</a></li>
	</ul>
	
	<table class="table">
		<tr>
			<th>부서번호</th>
			<th>부서명</th>
			<th>부서번호</th>
		</tr>
		<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.deptno }</td>
			<td><a href="detail?deptno=${dto.deptno }">${dto.dname }</a></td>
			<td>${dto.loc }</td>
		</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>