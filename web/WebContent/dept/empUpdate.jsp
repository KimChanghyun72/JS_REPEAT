<%@page import="member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empUpdate.jsp</title>
</head>
<body>
	<div class="regist">
		<form method="post" name="frm" id="frm" action="empUpdate.do">
			<h3 class="page_title">사원정보 수정</h3>
			<div>
				<label for="id">사원번호</label> <input type="text" name="employee_id"
					value="${emp.employee_id}" readonly="readonly">
			</div>

			<div>
				<label for="lastName"></label> <input type="text" id="lastName"
					name="lastName" value="${emp.last_name}">
			</div>
			
			<div>
				<select name="jobList">
					<c:forEach items="${jobList}" var="jobList">
						<option value="${jobList.job_id}">${jobList.job_title}
					</c:forEach>
				</select>
			</div>
			<div>
				<select name="department_List">
					<c:forEach items="${deptList}" var="deptList">
						<option value="${deptList.department_id}">${deptList.department_name }
					</c:forEach>
				</select>
			</div>
			<div>
				<input type="text" name="email" value="${emp.email}"><br>
				<fmt:parseDate value="${emp.hire_date}" pattern="yyyy-MM-dd" var="parseToday"/>
				<input type="text" name="hireDate" value="<fmt:formatDate value="${parseToday}" pattern="yyyy-MM-dd"/>">
				<!-- <input type="text" name="hireDate" value="${parseToday}"> -->
			</div>
			<div>
				<button type="reset">초기화</button>
				<!-- <button type="button" onclick="inputCheck()">등록</button> -->
				<button>등록</button>

			</div>

		</form>
	</div>
</body>
</html>