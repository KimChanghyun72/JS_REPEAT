<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>movie.jsp(jquery)</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script>

$(function(){
	//박스오피스 조회버튼
	$("#btnList").click(loadDoc);
	//영화상세정보 조회버튼
	$("#result").on("click",".movieCd", loadInfo);
	
});

/*---------------------------------------
 //박스오피스 조회. 
 -----------------------------------------*/
function loadDoc(){
	var doc = $("#name").val();
	var url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt="+doc;
	
	$.getJSON(url, function(obj){
		var arr = obj.boxOfficeResult.dailyBoxOfficeList;
		for(i=0; i<arr.length; i++){
			var tr = $("<tr>").append(
					 $("<td>").text(arr[i].movieCd).addClass("movieCd"), 
					 $("<td>").text(arr[i].movieNm));
			
			$("#result").append(tr);
		}
	})
};

/*---------------------------------------
//영화상세정보 조회. 
-----------------------------------------*/
function loadInfo(event){
	var doc2 = $(event.target).text();
	var url2 = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=430156241533f1d058c603178cc3ca0e&movieCd="+doc2;
	
	$.getJSON(url2, function(obj){
		var arr = obj.movieInfoResult.movieInfo;
		$("#info").html("감독 : "+arr.directors[0].peopleNm+"<br>");
		$("#info").html($("#info").html() + " 상영시간 : " + arr.showTm+"분<br>");
		for(var i=0; i<arr.actors.length; i++){
			$("#info").html($("#info").html() + "출연배우 : " + arr.actors[i].peopleNm+"<br>");
		}
			//감독 : movieInfoResult.movieInfo.directors[0].peopleNm
			//배우 : movieInfoResult.movieInfo.actors[i].peopleNm
			//상영시간 : movieInfoResult.movieInfo.showTm
		
		
	});
//영화코드에 해당하는 상세정보(감독, 배우, 상영시간)조회해서 div#info에 출력

}
</script>
</head>
<body>
	<input type="text" id="name" value="20200826">
	<button type="button" id="btnList">검색</button>
	<table id="result"></table>
	<div id="info"></div>
</body>
</html>