<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardInsert.jsp</title>
</head>
<body>
	<%@include file="../menu.jsp"%>
	<div class="regist">
	<form method="post" name="frm" id="frm" action="boardInsertProc.jsp">
			<h3 class="page_title"> 게시글등록</h3>
			<div>
				<label for="poster">poster</label>
				<input type="text" name="poster">
			</div>

			<div>
				<label for="subject">제목</label>
				<input type="text" id="subject">
			</div>
			
			<div>
				<label for="contents">내용 </label><br>
				<textarea id="contents" name="contents" rows="20"></textarea>
			</div>
			
			<div>
				<label for="postFile">첨부파일 </label><br>
				<input type="file" id="postFile" name="postFile">
			</div>

		</form>
		</div>
</body>
</html>