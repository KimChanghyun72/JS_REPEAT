<%@page import="member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function inputCheck(){
		//id, pw 필수입력 체크
		if(frm.id.value == ""){
			window.alert("id 입력");
			frm.id.focus();
			return false;
		}
		if(frm.pw.value==""){
			alert("pw 입력");
			frm.pw.focus();
			return false;
		}
		//job(select tag)선택되었는지 확인.
		//if(frm.job.selectedIndex > 0){
		if(frm.job.value==""){
			alert("job 입력");
			frm.job.focus();
			return false;
		}
		
		//radio, checkbox
		var gender = document.querySelectorAll("[name='gender']:checked").length;
		//name이 gender인 태그 중 checked되어있는 태그를 선택.
		if(gender == 0){
			alert("성별 적어도 하나는 선택");
			return false;
			}
	//회원가입폼 제출
		//frm.submit();
		return true;
		}
	
</script>
</head>
<body>
<%@include file="/common/header.jsp" %>
<% MemberVO member = (MemberVO)session.getAttribute("login"); %>
	<div class="regist">
		<form method="post" name="frm" id="frm" action="memberUpdate" onsubmit="return inputCheck()">
			<h3 class="page_title"> 회원등록</h3>
			<div>
				<label for="id">id</label>
				<input type="text" name="id" value="<%=member.getId() %>" readonly="readonly">
			</div>

			<div>
				<label for="pw">pwd</label>
				<input type="password" id="pw" name="password" value="<%=member.getPassword() %>" readonly="readonly">
			</div>

			<div>
				<label>gender : </label>
				<label class="label2">남자</label>
				<input type="radio" name="gender" value="male"
				 <%if("male".equals(member.getGender())){out.print("checked='checked'");} %>> 
				<label class="label2">여자</label>
				<input type="radio" name="gender" value="female"
				 <%if("female".equals(member.getGender())){out.print("checked='checked'");} %>>
			</div>

			<div>
				<label for="id">job : </label>
				<select name="job" id="job" >
					<option value="null">선택</option>
					<option value="programmer" <%if("programmer".equals(member.getJob())){out.print("selected='selected'");} %>>prog</option>
					<option value="account"  <%if("account".equals(member.getJob())){out.print("selected='selected'");} %>>account</option>
					<option value="clerk" <%if("clerk".equals(member.getJob())){out.print("selected='selected'");} %>>clerk</option>
					<option value="president" <%if("president".equals(member.getJob())){out.print("selected='selected'");} %>>president</option>
				</select>
			</div>
	
			<div>
				<label for="mailsend">메일 수신 여부 : </label> 
				<input type="checkbox" name="mailsend" value="accept" checked><br>
			</div>
			 <div>
			 <% String hobby = member.getHobby();
			 	if(hobby==null){
			 		hobby="";
			 	}%>
				<label for="hobby">취미</label> <!-- indexof -->
				<input type="checkbox" name="hobby" value="read"
				<% if(hobby.indexOf("read")>=0){out.print("checked='checked'");} %>>독서
				<input type="checkbox" name="hobby" value="game" 
				<% if(hobby.indexOf("game")>=0){out.print("checked='checked'");} %>>게임
				<input type="checkbox" name="hobby" value="sleep" 
				<% if(hobby.indexOf("sleep")>=0){out.print("checked='checked'");} %>>수면
			</div> 

			<div>
				<label for="reason">가입동기 : </label>
				<textarea id="reason" name="reason" rows="5"><%=member.getReason() %></textarea>
			</div>

			<div>
				<button type="reset" >초기화</button>
				<!-- <button type="button" onclick="inputCheck()">등록</button> -->
				<button>등록</button>
			
			</div>

		</form>
	</div>
</body>
</html>