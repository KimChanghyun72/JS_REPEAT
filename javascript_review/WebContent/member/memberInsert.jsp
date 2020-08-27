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
	<%@include file="../menu.jsp"%>
	<div class="regist">
		<form method="post" name="frm" id="frm" action="memberInsertProc.jsp" onsubmit="return inputCheck()">
			<h3 class="page_title"> 회원등록</h3>
			<div>
				<label for="id">id</label><input type="text" name="id">
			</div>

			<div>
				<label for="pw">pwd</label> <input type="password" id="pw">
			</div>

			<div>
				<label>gender : </label>
				<label class="label2">남자</label>
				<input type="radio" name="gender" value="male" checked> 
				<label class="label2">여자</label>
				<input type="radio" name="gender" value="female">
			</div>

			<div>
				<label for="id">job : </label>
				<select name="job" id="job">
					<option value="nullVal" selected>선택</option>
					<option value="progVal">prog</option>
					<option value="accountVal">account</option>
					<option value="clerkVal">clerk</option>
					<option value="presidentVal">president</option>
				</select>
			</div>

			<div>
				<label for="mailsend">메일 수신 여부 : </label> <input type="checkbox"
					name="mailsend" value="accept" checked><br>
			</div>

			<div>
				<label for="reason">가입동기 : </label>
				<textarea id="reason" name="reason" rows="5"></textarea>
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