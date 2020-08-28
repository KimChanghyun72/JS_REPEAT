<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jq_groupevent</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<script>
	$(function() {
		//버튼 클릭 : input tag값을 ul태그에 추가.
		$("#btnAdd").click(function() {
			$("<li>").text($("#fruit").val()).appendTo("ul");
			/* var li = $("<li>").text( $("#frult").val() );
			$("ul").append(li); */
		});
		//li 태그 마우스오버 이벤트 : 색 변경
		$("li").mouseover(function() {
			$(this).css("color", "coral");
		});
		$("li").mouseleave(function(){
			$(this).css("color","black");
		})
		//태그 각각에 이벤트를 거는 개별이벤트
		
		$("ul").on("mouseover keydown","li",function(){
			$(this).css("backgroundColor","yellow");
		})
	});
</script>
</head>
<body>
	<input id="fruit">
	<button type="button" id="btnAdd">추가</button>

	<ul>
		<li>자바
		<li>스프링
	</ul>
</body>
</html>