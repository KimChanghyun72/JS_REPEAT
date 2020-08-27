<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>js_String</title>
</head>
<body>
<h3>string object 연습</h3>
<div id="result"></div>
<script>
	var url="/member/memberInsert.jsp"
	var loc = url.lastIndexOf("/");
	var cutted = url.substring(parseInt(loc)+1);
	var division = document.createElement("div");
	division.innerHTML = cutted;
	document.body.appendChild(division);
	
	result.innerHTML=cutted;
</script>
</body>
</html>