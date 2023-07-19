<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.6.4.min.js" ></script>
<script>
$(document).ready(function(){
	$("#deletebtn").on('click' , function(){
		let inputpw = prompt("암호 입력하세요");
		let dbpw = ${detail.pw } ;
		if(inputpw == dbpw){
			location.href="boarddelete?seq=${detail.seq }";
		}
		else{
			alert("암호를 확인하세요");
		}
	});//on end
	$("#updatebtn").on('click' , function(){
		let inputpw = prompt("암호 입력하세요");
		let dbpw = ${detail.pw } ;
		if(inputpw == dbpw){
			$("form").attr("action", "boardupdate");
		}
		else{
			alert("암호를 확인하세요");
		}
	});//on end	
});//ready end
</script>
</head>
<body>
<h1> 상세 조회</h1>
<form action="">
번호:<input type=text name="seq" value='번호' readonly >
제목:<input type=text name="title" value="제목" ><br>
내용:<textarea rows=10 cols=100 name="contents">내용들</textarea><br>
작성자:<input type=text name="writer" value="${sessionid }" readonly ><br>
<input type=hidden name="pw" value=1111 ><br>
조회수 :<input type=text name="viewcount" value=10 readonly ><br>
<input type=button id="updatebtn" value="수정버튼" >
<input type=button id= "deletebtn" value="삭제버튼" >
</form>
</body>
</html>