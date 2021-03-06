<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function inputCheck() {
		//id, pw 필수입력 체크
		if (frm.id.value == "") {
			window.alert("id 입력");
			frm.id.focus();
			return false;
		}
		if (frm.pw.value == "") {
			alert("pw 입력");
			frm.pw.focus();
			return false;
		}
		//job(select tag)선택되었는지 확인.
		//if(frm.job.selectedIndex > 0){
		if (frm.job.value == "") {
			alert("job 입력");
			frm.job.focus();
			return false;
		}

		//radio, checkbox
		var gender = document.querySelectorAll("[name='gender']:checked").length;
		//name이 gender인 태그 중 checked되어있는 태그를 선택.
		if (gender == 0) {
			alert("성별 적어도 하나는 선택");
			return false;
		}
		//회원가입폼 제출
		//frm.submit();
		return true;
	}
</script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script>
$(function(){
	//초기화
	$("#frm [name=gender]").val(["${member.gender}"]);
	$("#frm [name=hobby]").val("${member.hobby}".replace("[","").replace("]","").split(", "));
	$("#frm [name=job]").val(["${member.job}"]);
	$("#frm [name=mailsend]").val(["${member.mailsend}"]);
});
</script>
</head>
<body>
	<h3 class="page_title">회원수정</h3>
	${error}
	<form action="${pageContext.request.contextPath}/memberSearch.do">
		<input type="hidden" name="job" value="update"> id : <input
			name="id">
		<button>검색</button>

	</form>
	<div class="regist">
		<%-- /frontWeb/memberInsert.do  or ../memberInsert.do //절대경로 직접적는건 좋은방법아님.--%>
		<%--<action="../memberInsert.do" --%>
		<c:if test="${not empty member}">
			<form method="post" name="frm" id="frm"
				action="${pageContext.request.contextPath}/memberUpdate.do"
				onsubmit="return inputCheck()">
				<h3 class="page_title">회원정보 수정</h3>
				<div>
					<label for="id">회원id</label><input name="id" id="id" value="${member.id}" readonly="readonly"> 
				</div>

				<div>
				<label for="pw">pwd</label> <input type="password" id="pw" name="password" value="${member.password}">
			</div>

			<div>
				<label>gender : </label>
				<label class="label2">남자</label>
					<input type="radio" name="gender" value="male"> 
				<label class="label2">여자</label>
					<input type="radio" name="gender" value="female">
			</div>

			<div>
				<label for="id">job : </label>
				<select name="job" id="job">
					<option value="null">선택</option>
					<option value="programmer">prog</option>
					<option value="account">account</option>
					<option value="clerk">clerk</option>
					<option value="president">president</option>
				</select>
			</div>

			<div>
				<label for="mailsend">메일 수신 여부 : </label> 
				<input type="checkbox" name="mailsend" value="accept"><br>
			</div>
			<div>
				<label for="mailsend">취미</label> 
				<input type="checkbox" name="hobby" value="read">독서
				<input type="checkbox" name="hobby" value="game">게임
				<input type="checkbox" name="hobby" value="sleep">수면
			</div>

			<div>
				<label for="reason">가입동기 : </label>
				<textarea id="reason" name="reason" rows="5">${member.reason}</textarea>
			</div>

			<div>
				<button type="reset" >초기화</button>
				<!-- <button type="button" onclick="inputCheck()">등록</button> -->
				<button>등록</button>
			</div>
			
			</form>
		</c:if>
	</div>
</body>
</html>