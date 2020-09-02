<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String id = (String)session.getAttribute("id"); %>

<ul>
<%	if( id == null){ %>
	<li><a href="/web/member/login.jsp">로그인</a>
<% } else { %>
	<li><%=id%>님 환영합니다.<a href="logout">로그아웃</a>
	<li><a href="/web/member/memberUpdate">회원정보 수정(get방식)</a>
<% } %>
	
	<li><a href="/web/dept/DeptInsertFormServ">부서등록폼(절대경로)</a>
	<li><a href="<%=application.getContextPath() %>/dept/deptSelectAll">부서전체조회(상대경로)</a>
	<li><a href="<%=application.getContextPath() %>/member/memberInsert">회원등록(context경로 (절대경로) 입력)</a>
	<li><a href="<%=application.getContextPath() %>/member/memberSelectAll">회원전체조회</a>
</ul>