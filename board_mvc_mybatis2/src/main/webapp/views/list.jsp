<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</head>
<body>

	<div class="container">
	<h3>게시판</h3>
	<a href="board.do?cmd=write"><input type="button" value="글쓰기"></a>
		<table class="table">
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성일자</th>
				<th>조회수</th>
				<th>아이피</th>
				<th>상태</th>
			</tr>
			<c:forEach items="${list }" var="vo">
			<tr>
				<td>${vo.bno }</td>
				<td>${vo.writer }</td>
				<td><a href="board.do?cmd=detail&bno=${vo.bno }"> ${vo.title }</a></td>
				<td>${vo.contents }</td>
				<td>${vo.regdate }</td>
				<td>${vo.hits }</td>
				<td>${vo.ip }</td>
				<td>${vo.status }</td>
			</tr>
		</c:forEach>
		
			<tr>
				<td colspan="4">
					<c:forEach begin="${startPage }" end="${endPage }" var="i" >
						<a href="board.do?cmd=list&cp=${i }">[${i }]</a>
					</c:forEach>
				</td>
			</tr>
			
		</table>
	</div>
</body>
</html>