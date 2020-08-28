<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jq_append2</title>
<script
src="https://code.jquery.com/jquery-3.5.1.js"
integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
crossorigin="anonymous"></script>
<script>
	$(function(){	//ready(load이전) 이벤트
		//td 클릭
			$("td").on("click",function(){
			$("#right").append($(this).parent());
			})
		//$("td").click(function(){})
		 
		$("#right").on("click","tr",function(){
			$("#left").append($(this));
		}) 
	});
</script>
</head>
<body>
<table id="left" border="1">
	<tr><td>홍길동</td><td>30</td></tr>
	<tr><td>김기자</td><td>31</td></tr>
	<tr><td>이기자</td><td>32</td></tr>
</table>
<br><br>

<table id="right" border="1">
</table>
</body>
</html>