<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	table{
		width: 900px;
		margin: auto;
		border-bottom: 1px solid black;
	}
	table,th,td{
		border-top: 1px solid black;
		border-collapse: collapse;
		text-align: center;
	}
</style>
<body>
	<table>
		
		<tr>
			<th>작성자</th>
			<td>${vo.writer }</td>
			<th>조회수</th>
			<td>${vo.hits }</td>
			<th>작성일시</th>
			<td>${vo.regdate }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="5">${vo.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="5">${vo.contents }</td>
		</tr>
		<tr>
			<td colspan="6">
				<a href="board.do"><input type="button" value="목록" /></a>
				<a href="board.do?cmd=modify&bno=${vo.bno }"><input type="button" value="수정" /></a>
				<a href="board.do?cmd=delete&bno=${vo.bno }"><input type="button" value="삭제" /></a>
				<!-- 
					삭제 버튼을 클릭하면 DeleteAction ==> dao에서 삭제 메서드를 호출후
					목록으로 리다이렉트
				 -->
			</td>
		</tr>
	</table>
</body>
</html>