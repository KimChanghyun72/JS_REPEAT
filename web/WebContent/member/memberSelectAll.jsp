
<%@page import="member.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deptSelectAll.jsp</title>
</head>
<body>
<%@include file="/common/header.jsp" %>
<table border="1">
<thead></thead>
	<tbody>
		<c:forEach items= "${list}" var="member">
				<tr>
					<td><a href="#">${member.id}</a></td>
					<td>${member.password }</td>
					<td>${member.job }</td> 
					<td>${member.reason }</td>
					<td>${member.gender }</td>
					<td>
						${member.mailsend }
						<c:if test="${not empty member.mailsend}"></c:if><button type="button">메일발송</button>
					</td>
					<td>${member.hobby }</td>
					<td>
					<fmt:parseDate value="${member.regdate}" pattern="yyyy-MM-dd HH:mm:ss" var="parseToday"/>
					<fmt:formatDate value="${parseToday}" pattern="MM-dd"/></td>
					<%-- <td>${member.regdate}</td> --%>
				</tr>
			</c:forEach>
<%-- <% 
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
%> --%>
	</tbody>
</table>
</body>
</html>