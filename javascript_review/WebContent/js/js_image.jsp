<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>js_image.jsp</title>
<style>
	img {width : 150px;}
</style>
</head>
<body>
<script>

var imgArr = ["../images/2018-12-14 (1).png",
			"../images/2018-12-14 (2).png",
			"../images/2019-05-25.png", 
			"../images/2020-07-18 (1).png"];
			

	for(var i=0; i<imgArr.length; i++){
		document.write("<img src='" + imgArr[i] + "'>");
	}
	for(var i=0; i<imgArr.length; i++){
		var img = document.createElement("img");
		img.src = imgArr[i];
		document.body.appendChild(img);
		
		img.addEventListener("mouseover",function(){
			this.style.width = "250px"})
		
		img.addEventListener("mouseout",function(){
			this.style.width = "100px"})
	}
	
</script>
</body>
</html>