<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deptInsertForm.jsp</title>
</head>
<body>
<%@include file="/common/header.jsp" %>
<form action="deptInsert" method="post">

	부서번호<input name="department_id"><br>
	부서명<input name="department_name"><br>
	지역 <select name="location_id">
			<option value="">선택
		<c:forEach items="${locationList }" var="location">
			<option value="${location.location_id }">${location.city}
		</c:forEach>
			
	</select>
	매니저 <select name="manager_id">
			<option value="">선택
		<c:forEach items="${mgrList}" var="mgr">
			<option value="${mgr.employee_id}">${mgr.last_name}
		</c:forEach>
	
	</select>
	<button>등록</button>
</form>
</body>
</html>