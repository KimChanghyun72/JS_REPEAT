<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>js_select</title>
</head>
<body>
<input id="txtFruit">
<button type="button" id="btnAdd" onclick="addFruit()">추가</button>
<button type="button" id="btnRm" onclick="rmFruit()">제거</button>
<select id="listFruit" size="10"></select>

<script>
function addFruit(){
	var x = document.getElementById("listFruit");
	var option = document.createElement("option");
	if(txtFruit.value==""||txtFruit.value==null){
		window.alert("내용 입력요망.");
		return;
	}else{	
	option.text = txtFruit.value;
	x.add(option);
	}
	txtFruit.value="";
}
function rmFruit(){
	var x = document.getElementById("listFruit");
	x.remove(x.selectedIndex);
}	
</script>
</body>

</html>