
<%@page import="member.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deptSelectAll.jsp</title>
</head>
<body>
<%@include file="/common/header.jsp" %>
<table border="1">
<% 
	ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("list");
	for(MemberVO member : list ){
%>
	<tr>
	<td><a href="memberSelect?id=<%=member.getId() %>"><%=member.getId() %></a></td>
	<td><%=member.getPassword() %></td>
	<td><%=member.getJob() %></td>
	<td><%=member.getReason() %></td>
	<td><%=member.getGender() %></td>
	<td><%=member.getMailsend() %></td>
	<td><%=member.getHobby() %></td>
	<td><%=member.getRegdate() %></td>
	</tr>
<%
	}
%>
</table>
</body>
</html>