<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style>
	label { display: inline-block; width : 100px}
</style>
</head>
<body>
   <h1>사원등록</h1>
   <form method="post" action="empInsert">  
    <div><label>employeeId</label> <input name="employeeId" value="${emp.___ }"></div>
    <div><label>firstName</label> <input name="firstName"></div>
    <div><label>lastName</label> <input name="lastName"></div>
    <div><label>email</label> <input name="email"></div>
    <div><label>hireDate</label> <input name="hireDate" value="2020/09/04"></div>
    
    <div><label>department_id</label> 
    	<c:forEach items="${deptList}" var="deptList">
    		<input type="radio" name="deptId" value="${deptList.department_id }">${deptList.department_name }
    	</c:forEach>
    	</div>
    <div><label>jobId</label> <select name="jobId">
    	<c:forEach items="${jobList}" var="jobList">
    		<option value="${jobList.job_id}">${jobList.job_title}
    	</c:forEach>
    	  </select></div>
    <div><label>manager_id</label> <select name="manager_id">
    	<c:forEach items="${mgrList}" var="mgrList">
    		<option value="${mgrList.employee_id}">${mgrList.last_name}
    	</c:forEach>
    	       </select></div>
    <button>등록</button>
    </form>
</body>
</html>