<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp_move</title>
<style>
	img{ width: 50px;
		top : 100px;
		left : 100px;
		position : relative;
		}
</style>
<script>
window.addEventListener("load", function(){
	/*document.addEventListener("mousemove",function(){
		//console.log(event.clientX, event.clientY);
		console.log(event.button);
		if(event.button == 0){
			img1.style.left = event.clientX + "px";
			img1.style.top = event.clientY + "px";
		}
	});*/
	
	document.addEventListener("keydown", function(){
		console.log(event.keyCode);
		console.log(img1.style.left, img1.style.top);
		if(event.keyCode==37){
			img1.style.left = (parseInt(img1.style.left) - 10)+"px";
		}
		/*else if(event.keyCode==39){
			img1.style.left = (parseInt(img1.style.left) + 10);
		}else if(event.keyCode==38){
			img1.style.top = (parseInt(img1.style.top) + 10);
		}else if(event.keyCode==40){
			img1.style.top = (parseInt(img1.style.top) - 10);
		}*/
	});
	
	
})
</script>
</head>
<body>
<img src="../images/2018-12-14 (1).png" id = "img1">

</body>
</html>