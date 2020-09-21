<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	
</script>
</head>
<body>
	<div class="regist">
		<form method="post" name="frm" id="frm" action="boardInsert.do">
			<h3 class="page_title"> 게시글등록</h3>
			<div>
				<label for="poster">Poster : </label>
				<input type="text" name="poster">
			</div>

			<div>
				<label for="subject">Subject : </label>
				<input type="text" id="subject" name="subject">
			</div>

			<div>
				<label for="contents">Contents : </label>
				<textarea name="contents"></textarea>
			</div>
			<label for="filename">file : </label><input type="file" name = "filename">
			<div>
				<button type="reset" >초기화</button>
				<!-- <button type="button" onclick="inputCheck()">등록</button> -->
				<button>등록</button>
			
			</div>

		</form>
	</div>
</body>
</html>