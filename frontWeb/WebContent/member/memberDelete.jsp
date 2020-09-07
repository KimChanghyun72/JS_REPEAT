<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberSearch.jsp</title>
<script>
	if('${errorCode}'==1){
		alert('${error}');
		}
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/memberDelete.do">
		id : <input name="id">
		<button>삭제</button>

	</form>
	<div>${error}</div>

</body>
</html>