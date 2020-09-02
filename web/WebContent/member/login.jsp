<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body>
<%=request.getAttribute("errorMsg")%>
	<form method="post" name="frm" id="frm" action="login">
			<div>
				<label for="id">id</label>
				<input type="text" name="id">
			</div>

			<div>
				<label for="pw">pwd</label>
				<input type="password" id="pw" name="password">
			</div>
			<button>로그인</button>
	</form>
</body>
</html>