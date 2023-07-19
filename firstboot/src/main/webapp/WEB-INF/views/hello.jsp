<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="/js/jquery-3.6.4.min.js"></script>
<script>
$(document).ready(function(){
	$("#ajaxbtn").on('click', function(){
		$.ajax({
			url: "helloajax",
			type :"get",
			dataType:"JSON",
			success : function(server){
				$("#result").html(server.model);
			},
			error : function(error){
				alert(error);
			}
		});
		
	});
	
	
});
</script>

</head>
<body>
<h1>hello.jsp  파일입니다</h1>
<h1>${model }</h1>

<img src="/images/html5.jpg" >
<img src="/upload/drinks.jpg" >


<input type=button value="ajax요청버튼" id="ajaxbtn">
ajax결과출력 <h1 id="result"></h1>

</body>
</html>