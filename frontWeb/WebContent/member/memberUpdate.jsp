<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<div class="regist">
	<%-- /frontWeb/memberInsert.do  or ../memberInsert.do //절대경로 직접적는건 좋은방법아님.--%>
		 <%--<action="../memberInsert.do" --%>
		 
		<form method="post" name="frm" id="frm"
		 action="${pageContext.request.contextPath}/memberUpdate.do"
		 onsubmit="return inputCheck()">
			<h3 class="page_title"> 회원정보 수정</h3>
			<div>
				<label for="id">회원id</label>
				<select name="id" id="id">
					<c:forEach items="${memList}" var="memList">
						<option value="${memList.id}">${memList.id}
					</c:forEach>
				</select>
			</div>
			
			<div>
				<button type="reset" >초기화</button>
				<!-- <button type="button" onclick="inputCheck()">등록</button> -->
				<button>수정</button>
			</div>
			

		</form>
	</div>
</body>
</html>