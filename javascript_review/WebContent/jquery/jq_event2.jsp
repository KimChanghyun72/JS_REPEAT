<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>js_event2</title>
<script
src="https://code.jquery.com/jquery-3.5.1.js"
integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
crossorigin="anonymous"></script>
<script>
	$(window).on("load",alertName);
	function alertName(){
		$("#tb1").on("click",function(event){
			console.dir(event.target); 
			console.dir(this);
			alert($(event.target).closest("tr").children().eq(0).html());
		})
	}
	/*tb1.addEventListener("click", function(){
		console.dir(event.target);   //버튼
		console.dir(this); 		 //table
		alert(event.target.parentNode.parentNode
					.getElementsByTagName("td")[0].innerHTML);
	});
	
	window.addEventListener("load",function(){
		*/
		/*var btns = document.getElementsByClassName("btnSelect");
		for(i=0;i<btns.length; i++){
			btns[i].addEventListener("click",function(){
				var td = this.parentNode.parentNode.getElementsByTagName("td")[0];
				alert(td.innerHTML);
			})
		}*/
		
		/*var btns = document.querySelectorAll(".btnSelect");
		for(i=0; i<btns.length; i++){
			btns[i].addEventListener("click",function(){
				var name = this.parentNode.parentNode.querySelector("td");
				
				
				if(this.innerHTML == name.innerHTML){
					this.innerHTML = "선택";
				}else{
					this.innerHTML = name.innerHTML;
				}
			})
		}*/
		/*tb1.addEventListener("click", function(){
			console.dir(event.target);   //버튼
			console.dir(this); 		 //table
			alert(event.target.parentNode.parentNode
						.getElementsByTagName("td")[0].innerHTML);
		});
		*/
	//});
</script>
</head>
<body>
<table border="1" id="tb1">
	<tbody>
		<tr>
			<td>kim</td>
			<td>30</td>
			<td><button type="button" class="btnSelect">선택</button></td>
		</tr>
		<tr>
			<td>park</td>
			<td>25</td>
			<td><button type="button" class="btnSelect">선택</button></td>
		</tr>
		<tr>
			<td>choi</td>
			<td>40</td>
			<td><button type="button" class="btnSelect">선택</button></td>
		</tr>
	</tbody>
</table>
</body>
</html>