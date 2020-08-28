<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberSearch</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	<input type="text" id="name">
	<button type="button" onclick="loadDoc()">검색</button>
	<div id="result"></div>
	
	<script>
	function loadDoc() {
		//1. XHR 객체 생성
		var xhttp = new XMLHttpRequest();
		//2. 콜백함수
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4) {
				if (this.status == 200) {
					//json으로 결과받은경우 var obj = JSON.parse(this.responseText);
					var obj = JSON.parse(this.responseText);
					for (var i = 0; i < obj.boxOfficeResult.dailyBoxOfficeList.length; i++) {
						document.getElementById("result").innerHTML += obj.boxOfficeResult.dailyBoxOfficeList[i].movieNm+"<br>";
								+ "<br>";
					}
				}else {
					document.getElementById("result").innerHTML += this.status + " , "
																+ this.statusText;
				}

			} else {
				document.getElementById("result").innerHTML = "로딩중<br>";
			}
		};
		//3.요청준비
		//var doc2 = $("#name").val();
		var doc = document.getElementById("name").value;
		var url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt="+doc;
		xhttp.open("GET", url, true);
		//4.요청시작
		xhttp.send();
	}
</script>
</body>
</html>

