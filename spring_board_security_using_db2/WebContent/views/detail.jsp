<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		$("input[value='목록']").on("click",function(){
			location.href = 'list';
		})
		$("input[value='수정']").on("click",function(){
			location.href = 'modify';
		})
	})
</script>
</head>
<body>
	<div class="container">
		<table class="table">
			<tr>
				<th>게시물번호</th>
				<th colspan="2">${detail.bno }</th>
				<th>작성자</th>
				<th colspan="2">${detail.writer }</th>
			</tr>
			<tr>
				<th>작성일</th>
				<th>${detail.regdate }</th>
				<th>IP</th>
				<th>${detail.ip }</th>
				<th>상태정보</th>
				<th>${detail.status }</th>
			</tr>
			<tr>
				<th>제목</th>
				<th colspan="5">${detail.title }</th>
			</tr>	
			<tr>
				<th>내용</th>
				<th colspan="5">${detail.contents }</th>
			</tr>
			<tr>
				<td colspan="6">
					<input type="button" value="목록" class="btn btn-outline-primary"/>
					<a href="modify?bno=${detail.bno }" class="btn btn-outline-secondary">수정</a>					
					<a href="delete?bno=${detail.bno }" class="btn btn-outline-danger">삭제</a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>