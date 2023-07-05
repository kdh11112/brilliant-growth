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
<link rel="stylesheet" href="../summernote/summernote-lite.css">
<script src="../summernote/summernote-lite.js"></script>
<script src="../summernote/summernote-ko-KR.js"></script>
<script type="text/javascript">
	$(function(){
		$("input[value='작성']").on("click",function(){
			//버튼으로 서브밋을 처리하는방법
			document.frm.method="POST";
			document.frm.action="writer";
			document.frm.submit();
		})
		
	})
</script>
</head>
<body>
	<div class="container">
    <form name="frm" method="POST" action="list">
		<table class="table" >
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" id="" /></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" id="" /></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="30" name="contents" class="summernote"></textarea></td>
			</tr>
			<tr>
				<td colspan="1">
					<a href="list" class="btn btn-outline-success">목록</a>
					<input type="submit" value="작성" class="btn btn-outline-info"/>
				</td>
			</tr>
		</table>
	</form>
</div>
	
	 <script type="text/javascript">
        		$('.summernote').summernote({
        		  disableDragAndDrop: true,
				  height: 300,                 // 에디터 높이
				  minHeight: null,             // 최소 높이
				  maxHeight: null,             // 최대 높이
				  focus: true, // 에디터 로딩후 포커스를 맞출지 여부
				  lang: "ko-KR",
					// 한글 설정
				  placeholder: '최대 2048자까지 쓸 수 있습니다',	//placeholder 설정
				  toolbar: [
					    ['fontname', ['fontname']],
					    ['fontsize', ['fontsize']],
					    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
					    ['color', ['forecolor','color']],
					    ['para', ['ul', 'ol', 'paragraph']],
					    ['height', ['height']]
					  ],
					  fontNames: ['맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
					  fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
			})	
		</script>
</body>
</html>