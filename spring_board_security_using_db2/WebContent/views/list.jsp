<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
<script type="text/javascript">
$(function(){
	$("input[value='작성']").on("click",function(){
		location.href = 'writer';
	})
})
</script>
</head>
<body>
	<div class="container">
<%-- 	<h3>currentPage : ${currentPage }</h3>
	<h3>totalNumber : ${totalNumber }</h3>
	<h3>countPerPage : ${countPerPage }</h3>
	<h3>totalPage : ${totalPage }</h3>
	<h3>startNo : ${startNo }</h3>
	<h3>endNo : ${endNo }</h3>
	<h3>startPageNo : ${startPageNo }</h3>
	<h3>endPageNo : ${endPageNo }</h3>
	<h3>prev : ${prev }</h3>
	<h3>next : ${next }</h3> --%>
		<table class="table">
			<tr>
				<td><input type="button" value="작성" class="btn btn-outline-info"/></td>
			</tr>
			<tr>
				<th>bno</th>
				<th>writer</th>
				<th>title</th>
				<th>contents</th>
				<th>regdate</th>
				<th>hits</th>
				<th>ip</th>
				<th>status</th>
			</tr>
			<c:forEach var="list" items="${list }">
				<tr>
					<td>${list.bno }</td>
					<td>${list.writer }</td>
					<td><a href="detail?bno=${list.bno }">${list.title }</a></td>
					<td>${list.contents }</td>
					<%-- <td>${list.regdate }</td> --%>
					<td>
					<fmt:parseDate var="dateString" value="${list.regdate }" pattern="yyy-MM-dd HH:mm:ss"/>
					<fmt:formatDate value="${dateString}" pattern="yyyy-MM-dd"/>
					</td>
					<td>${list.hits }</td>
					<td>${list.ip }</td>
					<td>${list.status }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4">
					<nav aria-label="Page navigation example">
				  	<ul class="pagination">
				  	<c:if test="${prev }">
				    	<li class="page-item"><a class="page-link" href="#">Previous</a></li>
				  	</c:if>				    
						<c:forEach var="i" begin="${startPageNo }" end="${endPageNo }">
							<li class="page-item"><a class="page-link" href="list?currentPage=${i }">${i }</a></li>
						</c:forEach>
					<c:if test="${next }">
				    	<li class="page-item"><a class="page-link" href="#">Next</a></li>
					</c:if>				    
				  </ul>
				</nav>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>