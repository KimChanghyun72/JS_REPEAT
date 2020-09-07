<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
<h3>멤버관련 CRUD</h3>
<ul>
	<li><a href="member/memberSearch.jsp">멤버 찾기</a>
	<li><a href="member/memberInsert.jsp">멤버 등록</a>
	<li><a href="member/memberDelete.jsp">멤버 삭제</a>
	<li><a href="${pageContext.request.contextPath}/memberSelectAll.do">멤버 수정</a>
	
</ul>
</body>
</html>