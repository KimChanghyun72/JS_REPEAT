<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원 통계</h3>

<h5>남여 비율</h5>
<% List<HashMap<String, Object>> list = 
	(List<HashMap<String, Object>>)request.getAttribute("genderCnt"); 
	for(HashMap<String, Object> temp : list){
%>
	<span><%=temp.get("gender") %> : </span><%=temp.get("cnt") %><span></span><br>
<%
	}
%>


<h5>직업별 회원수</h5>

<h5>메일수신회원 수 : </h5>
<%=request.getAttribute("mailCnt") %>
</body>
</html>