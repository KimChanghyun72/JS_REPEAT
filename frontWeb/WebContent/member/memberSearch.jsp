<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원검색</title>
<script>
	function decoTest(){
		console.log("test");
	}
</script>
</head>
<body>
<h3>회원 검색 페이지</h3>
<a href="${pageContext.request.contextPath}/memberList.do">전체검색</a>
	<form action="${pageContext.request.contextPath}/memberSearch.do">
	<input type="hidden" name="job" value="search">
		id : <input name="id">
		<button>창효니</button>

	</form>
	<div>${error}</div>

</body>
</html>