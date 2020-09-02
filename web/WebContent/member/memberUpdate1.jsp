<%@page import="member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberUpdate1.jsp</title>
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

	<div class="regist">
		<form method="post" name="frm" id="frm" action="memberUpdate" onsubmit="return inputCheck()">
			<h3 class="page_title"> 회원등록</h3>
			<div>
				<label for="id">id</label>
				<input type="text" name="id" value="${login.id}" readonly="readonly">
			</div>

			<div>
				<label for="pw">pwd</label>
				<input type="password" id="pw" name="password" value="${sessionScope.login.password}" readonly="readonly">
			</div>

			<div>
				<label>gender : </label>
				<label class="label2">남자</label>
				<input type="radio" name="gender" value="male" 
				<c:if test="${login.gender='남' }">checked="checked"</c:if>>
				<label class="label2">여자</label>
				<input type="radio" name="gender" value="female"
				<c:if test="${login.gender='여' }">checked="checked"</c:if>>
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
			 
				<label for="hobby">취미</label> <!-- indexof -->
				<input type="checkbox" name="hobby" value="read" 
				<c:if test="${login.hobby='read' }">checked="checked"</c:if>>독서
				<input type="checkbox" name="hobby" value="game" 
				<c:if test="${login.hobby='game' }">checked="checked"</c:if>>게임
				<input type="checkbox" name="hobby" value="sleep" 
				<% if(hobby.indexOf("sleep")>=0){out.print("checked='checked'");} %>>수면
			</div> 

			<div>
				<label for="reason">가입동기 : </label>
				<textarea id="reason" name="reason" rows="5">${sessionScope.login.reason }</textarea>
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