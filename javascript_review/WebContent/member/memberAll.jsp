<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberAll</title>
</head>
<body>
<%@include file="../menu.jsp" %>
	<h3 class="page_title">회원 전체</h3>
	<div>
	<ul class="search">
		<li>메일수신여부</li>
		<li>성별</li>
		<li><button type="button">검색</button></li>
	</ul>
	</div>
	
	<table id="members">
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
			<tr>
			<td><a href="memberSelect.jsp">kch1234</a></td>
			<td>1234</td>
			<td>prog</td>
			<td>male</td>
			<td>yes</td>
			</tr>
			<tr>
			<td><a href="memberSelect.jsp">kch1</a></td>
			<td>1234</td>
			<td>account</td>
			<td>female</td>
			<td>no</td>
			</tr>
			<tr>
			<td><a href="memberSelect.jsp">kch12345</a></td>
			<td>1234</td>
			<td>prog</td>
			<td>female</td>
			<td>yes</td>
			</tr>
		</tbody>

	</table>
</body>
</html>