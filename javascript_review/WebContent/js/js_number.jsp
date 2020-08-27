<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp_number</title>
</head>
<body>
	<input name="num1" id="num1">+
	<input name="num2" id="num2">=
	<input name="result" id="result">
	<button type="button" name=btnResult id= "btnResult" onclick="checkResult()" >결과확인</button>
	<button type="button" onclick="init()">초기화</button>
	<div id="divResult">	</div>
	<script>
			num1.value = Math.floor(Math.random()*100);
			num2.value = Math.floor(Math.random()*100);
			
			var cntRight=0;
			var cntWrong=0;
			function checkResult(){
			//두 수의 합이 result 와 같으면 같다고 다르면 다르다고 alert
			var sum = parseInt(num1.value) + parseInt(num2.value)
				if(sum == result.value){
					//window.alert("마즘");
					cntRight++;
					divResult.innerHTML +="마즘<br>"
				}else{
					//window.alert("틀림 답은 = "+ sum)
					cntWrong++;
					divResult.innerHTML +="틀림<br>"
				}
			
				if((cntRight+cntWrong) == 5){
					window.alert((cntRight*20) + "점입니다.");
					btnResult.disabled = "disabled";
					//아이디 기준으로 하네?
					divResult.innerHTML =""
				}else{
					init();
				}
			}
			
			//함수 선언.
			function init(){
				num1.value = Math.floor(Math.random()*100);
				num2.value = Math.floor(Math.random()*100);
				result.value = "";
			}
			
</script>
</body>
</html>