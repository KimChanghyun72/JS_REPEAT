<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../menu.jsp" %>
<h3 class="page_title">게시글 전체</h3>
<table id="members">
		<thead>
			<tr>
				<th>poster</th>
				<th>title</th>
				<th>contents</th>
				<th>file</th>
			</tr>
		</thead>
		<tbody>		
			<tr>
			<td>kch1234</td>
			<td><a href="boardSelect.jsp">주4일근무 희망</a></td>
			<td>월급 300이상 휴가 빵빵하게</td>
			<td>hope1.txt</td>
			</tr>
			<tr>
			<td>kch1</td>
			<td><a href="boardSelect.jsp">자고싶다</a></td>
			<td>놀고싶다</td>
			<td>hope2.txt</td>
			</tr>
			<tr>
			<td>kch12345</td>
			<td><a href="boardSelect.jsp">게임하고싶다</a></td>
			<td>갓겜하고싶다</td>
			<td>hope3.txt</td>
			</tr>
		</tbody>

	</table>
</body>
</html>