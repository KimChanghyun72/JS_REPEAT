<%@page import="member.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberAll</title>
</head>
<body>
	<h3 class="page_title">회원 전체</h3>
	<div>
	<ul class="search">
		<li>메일수신여부</li>
		<li>성별</li>
		<li><button type="button">검색</button></li>
	</ul>
	</div>
	
	<table id="members" border="1">
		<thead>
			<tr>
				<th>id</th>
				<th>pw</th>
				<th>job</th>
				<th>gender</th>
				<th>mailsend</th>
			</tr>
		</thead>
		<tbody>		
			<c:forEach items= "${list}" var="temp">
				<tr>
					<td><a href="memberSelect.jsp">${list.id}</a></td>
					<td>${list.password }</td>
				</tr>
			</c:forEach>
			
			<%-- <%
				ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("list");
				for(MemberVO member : list){
			%>
						
				<tr>
				<td><a href="memberSelect.jsp"><%=member.getId() %></a></td>
				<td><%=member.getPassword() %></td>
				</tr>
			<%
				}
			%> --%>
		</tbody>

	</table>
</body>
</html>