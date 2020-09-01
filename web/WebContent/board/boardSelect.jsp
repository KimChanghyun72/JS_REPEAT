<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberSelect</title>
</head>
<body>
<h3 class="page_title">내 정보 조회</h3>
<div><span class="label">글 번호 : </span><span>${board.no}</span></div>
<div><span class="label">작성자 : </span><span>${board.poster }</span></div>
<div><span class="label">제목 : </span><span>${board.subject}</span></div>
<div><span class="label">내용 : </span><span>${board.contents }</span></div>
<div><span class="label">작성일자 : </span><span>${board.lastpost }</span></div>
<div><span class="label">뷰 : </span><span>${board.views }</span></div>
<div><span class="label">파일이름 : </span><span>${board.filename }</span></div>
<button type="button" ID="btnPage">목록으로</button> 

<script>
	btnPage.addEventListener("click", goPage);
	function goPage(){
		//history.back();
		//history.go(-1);//이전페이지로 이동.
		//location.href="memberAll.jsp"
		location.assign("boardSelectAll.jsp");
	}
</script>
</body>
</html>