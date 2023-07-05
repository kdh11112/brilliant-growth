<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script type="text/javascript" src="../lang/summernote-ko-KR.js"></script>
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

	<div id="container">
		<form action="board.do">
			<table>
				<tr>
					<th>작성자</th>
					<td>${vo.writer }</td>
					<th>조회수</th>
					<td>${vo.hits }</td>
					<th>작성일시</th>
					<td>${vo.regdate }
						<input type="hidden" name="bno" value="${vo.bno }"/>
						<input type="hidden" name="cmd" value="modifyOk"/>
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="5"><input type="text" name="title" id="" value="${vo.title }"/></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="5"><textarea class="summernote" name="contents" id="" cols="30" rows="10">${vo.contents }</textarea></td>
				</tr>
				<tr>
					<td colspan="6">
						<a href="list.jsp"><input type="button" value="목록" /></a>
						<input type="submit" value="수정" />
					</td>
				</tr>
			</table>
		</form>
	</div>
		
		<script type="text/javascript">
			$(".summernote").summernote({
				height:150,
				lang:"ko-KR",
				//에디어에 커서 이동
				focus:true,
				toolbar : [
					//글꼴
					['fontname',['fontname']],
					//글자 크기
					['fontsize',['fontsize']],
					//굵기 기울임꼴,밑줄,취소선,서식지우기
					['style',['bold','italic','underline','strikethrough','clear']],
					//글자색
					['color',['forecolor','color']],
					//표만들기
					['table',['table']]
					],
					//추가한 글꼴
					fontNames:['Arial','Arial Black','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
					//추가한 폰트 사이즈
					fontSizes:['8','9','10','11','12','14','16','18','20','22']
			});
		</script>
</body>
</html>