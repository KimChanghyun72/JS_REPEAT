<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp_number</title>
<script
src="https://code.jquery.com/jquery-3.5.1.js"
integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
crossorigin="anonymous"></script>
</head>
<body>
	<input name="num1" id="num1">+
	<input name="num2" id="num2">=
	<input name="result" id="result">
	<button type="button" name=btnResult id="btnResult">결과확인</button>
	<button type="button">초기화</button>
	<div id="divResult">	</div>
	<script>
			
			
			//$("#num1").val() = Math.floor(Math.random()*100);
			$("#num1").val(Math.floor(Math.random()*100));
			//$("#num2").val() = Math.floor(Math.random()*100);
			$("#num2").val(Math.floor(Math.random()*100));
		
			var cntRight=0;
			var cntWrong=0;
			function checkResult(){
			//두 수의 합이 result 와 같으면 같다고 다르면 다르다고 alert
			var sum = parseInt($("#num1").val()) + parseInt($("#num2").val())
				if(sum == $("#result").val()){
					//window.alert("마즘");
					cntRight++;
					$("#divResult").html() +="마즘<br>"
				}else{
					//window.alert("틀림 답은 = "+ sum)
					cntWrong++;
					$("#divResult").html() +="틀림<br>"
				}
			
				if((cntRight+cntWrong) == 5){
					$("window").alert((cntRight*20) + "점입니다.");
					//btnResult.disabled = "disabled";
					$("#btnResult").attr("disabled","disabled").html("");
					//아이디 기준으로 하네?
					//divResult.innerHTML =""
					//$("#divResult").html("");
				}else{
					init();
				}
			}
			
			//함수 선언.
			function init(){
				//num1.value = Math.floor(Math.random()*100);
				$("#num1").val(Math.floor(Math.random()*100));
				//num2.value = Math.floor(Math.random()*100);
				$("#num2").val(Math.floor(Math.random()*100));
				//result.value = "";
				$("#result").val("");
			}
			
			$("#btnResult").on("click","checkResult");
			
</script>
</body>
</html>