<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>js_event</title>
<style>
	.price {display: none;}
</style>
<script>
	window.addEventListener("load", init);
	
	function init(){
		//클래스가 타이틀인 태그 찾기.
		var titles = document.getElementsByClassName("title");
		for(i=0; i<titles.length; i++){
			titles[i].addEventListener("mouseenter", function(){
				var price = this.parentNode.getElementsByClassName("price")[0];
				price.style.display="inline";
			});
			titles[i].addEventListener("mouseleave", function(){
				var price = this.parentNode.getElementsByClassName("price")[0];
				price.style.display="none";
			})
		}
		/*var titles = document.querySelectorAll(".title");
		for(price of titles){
			price.addEventListener("mouseenter", function(){
				var price = this.parentNode.getElementsByClassName("price")[0];
				price.style.display="inline";
		}
		}*/
	}
</script>
</head>
<body>
	<div>
		<span class="title">스프링</span> <span class="price">5000</span>
	</div>
	<div>
		<span class="title">자바</span> <span class="price">4000</span>
	</div>
	<div>
		<span class="title">자바스크립트</span> <span class="price">3000</span>
	</div>
</body>
</html>