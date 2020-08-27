<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div {padding : 30px;
		border : 1px solid blue;
		}
</style>
<script>
	window.addEventListener("load", function(){
		a.addEventListener("click", function(){alert("A");});
		b.addEventListener("click", function(){alert("B");});
		c.addEventListener("click", function(){
			alert("C");
			//window.event.preventDefault();
			window.event.stopPropagation();	//전파 중지.
			});
		linka.addEventListener("click", function(){
			if(!confirm("이동할까요?")){
				window.event.preventDefault(); //a, submit등의 디폴트 기능이 있는 태그들의 디폴트 기능을 중지.
			}else{
				
			}
		});
			
	});
</script>
</head>
<a href="js_event.jsp" id="linka">이벤트 테스트</a>
<body>
	<div id="a">A
		<div id="b">B
			<div id="c">C</div>
		</div>
	</div>
</body>
</html>