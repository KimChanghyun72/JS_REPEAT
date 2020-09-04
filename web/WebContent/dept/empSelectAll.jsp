<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style>
label {
	display: inline-block;
	width: 100px
}
</style>
</head>
<body>
	<h1>사원등록</h1>
	<form method="post" action="">
		<c:forEach items="${empList}" var="empList">
			<div>
				<label>employeeId</label> <input name="employeeId"
					value="${empList.employee_id}">
			</div>
			<div>
				<label>firstName</label> <input name="firstName"
					value="${empList.first_name}">
			</div>
			<div>
				<label>lastName</label> <input name="lastName"
					value="${empList.last_name }">
			</div>
			<div>
				<label>email</label> <input name="email" value="${empList.email}">
			</div>
			<div>
				<label>hireDate</label> <input name="hireDate"
					value="${empList.hire_date}">
			</div>
			<div>
				<label>deptId</label> <input name="hireDate"
					value="${empList.department_id}">
			</div>
			<div>
				<label>jobId</label> <input name="hireDate"
					value="${empList.job_id}">
			</div>
			<div>
				<label>manager_id</label> <input name="hireDate"
					value="${empList.manager_id}">
			</div>
			<button>등록</button>
		</c:forEach>
	</form>
</body>
</html>