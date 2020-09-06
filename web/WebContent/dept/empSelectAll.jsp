<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>empSelectAll.jsp</title>
<style>
label {
	display: inline-block;
	width: 100px
}
</style>
</head>
<body>
	<h1>전체 사원 조회</h1>
	<table border="1">
		<tr>
			<th>사원ID</th>
			<th>사원 이름</th>
			<th>부서명</th>
			<th>직군명</th>
			<th>매니저ID</th>
		</tr>
		<c:forEach items="${empList}" var="empList">
			<tr>

				<td><a href="empUpdate.do?employee_id=${empList.employee_id}">${empList.employee_id}</a></td>
				<td>${empList.last_name }</td>
				<td>${empList.department_id}</td>
				<td>${empList.job_id}</td>
				<td>${empList.manager_id}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>