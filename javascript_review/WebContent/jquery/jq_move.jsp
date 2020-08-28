<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jq_move</title>
<style>
img {
	width: 50px;
	top: 100px;
	left: 100px;
	position: relative;
}
</style>
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>

</head>
<body>
	<img id="img1" src="../images/2018-12-14 (1).png">

	<script>

$("#img1").css("left","100px");
$("#img1").css("top","100px");

$(window).on("load",keyMv).on("load", mouseMv);
 function mouseMv(){
	$(document).on("mousemove", function(event){
		console.log(event.clientX, event.clientY);
		$("#img1").css("left",(event.pageX+"px"));
		$("#img1").css("top",(event.pageY+"px"));
	})
} 

 function keyMv(){
	$(document).on("keydown", function(event){
		if(event.keyCode==37){
			console.log($("#img1").css("left"));
			$("#img1").css("left",parseInt($("#img1").css("left"))-10+"px");
		}else if(event.keyCode==39){
			$("#img1").css("left",parseInt($("#img1").css("left"))+10+"px");
		}else if(event.keyCode==38){
			$("#img1").css("top",parseInt($("#img1").css("top"))-10+"px");
		}else if(event.keyCode==40){
			$("#img1").css("top",parseInt($("#img1").css("top"))+10+"px");
		};
	});
} 
</script>

</body>
</html>