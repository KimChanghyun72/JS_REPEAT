<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberSelect</title>
</head>
<body>
<%@include file="../menu.jsp" %>
<h3 class="page_title">내 정보 조회</h3>
<div><span class="label">id</span><span>kch1234</span></div>
<div><span class="label">패스워드</span><span>12345</span></div>
<div><span class="label">직업</span><span>prog</span></div>
<div><span class="label">가입동기</span><span>for program study</span></div>
<div><span class="label">성별</span><span>male</span></div>
<div><span class="label">메일수신여부</span><span>yes</span></div>
<button type="button" ID="btnPage">목록으로</button>

<script>
	btnPage.addEventListener("click", goPage);
	function goPage(){
		//history.back();
		//history.go(-1);//이전페이지로 이동.
		//location.href="memberAll.jsp"
		location.assign("memberAll.jsp");
	}
</script>
</body>
</html>