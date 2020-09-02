
<%@page import="board.BoardVO"%>
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
<table border="1">
<% 
	ArrayList<BoardVO> list = (ArrayList<BoardVO>)request.getAttribute("list");
	for(BoardVO board : list ){
%>
	<tr>
	<td><a href="boardSelect?no=<%=board.getNo() %>"> <%=board.getNo() %> </a></td>
	<td><%=board.getPoster() %></td>
	<td><%=board.getSubject() %></td>
	<td><%=board.getContents() %></td>
	<td><%=board.getLastpost() %></td>
	<td><%=board.getViews() %></td>
	<td><%=board.getFilename() %></td>
	</tr>
<%
	}
%>
</table>
</body>
</html>