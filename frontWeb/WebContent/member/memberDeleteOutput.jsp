<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberDeleteOutput.jsp</title>
<script>
	if('${result}'!=null||'${result}'!=""){
		alert('${result}');
	}
</script>
</head>
<body>
	<div>삭제 아웃풋에 온 것을 환영하오 나썬이여. 나는 나에 멤버들을 굽어 살피는 깨우친 메쏘드 세종이라 하오.</div>
	<div>${result}건이 삭제되었다오.</div>
</body>
</html>