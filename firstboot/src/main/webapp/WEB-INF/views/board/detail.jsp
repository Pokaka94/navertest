<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/js/jquery-3.6.4.min.js"></script>
<script>
$(document).ready(function(){
	$("#deletebtn").on('click', function(){
		let inputpw = prompt("암호 입력하세요");
		//let dbpw = ${detaildto.pw };
		let dbpw = $("input:hidden").val();
		if(inputpw == dbpw) {
			location.href="boarddelete?seq=${detaildto.seq }";  
		}
		else{
			alert("암호를 확인하세요.");
		}
	});//on end
	
	$("#updatebtn").on('click', function(){
		let inputpw = prompt("암호 입력하세요");
		let dbpw = $("input:hidden").val();
		if(inputpw == dbpw) {
			$("form").attr("action", "boardupdate");
			$("form").attr("method", "post");
			$("form").submit();
			//method=post
			//button(기능 구현 - 기본 기능 없다)
			//폼 /.submit()
			
		}
		else{
			alert("암호를 확인하세요.");
		}
	});//on end
	
	
});			
</script>
</head>
<body>
<form action="" method="" >
번호 : <input type=text name='seq' value="${detaildto.seq }" readonly ><br>
제목 : <input type=text name="title" value="${detaildto.title }"><br>
내용 :<textarea rows="5" cols="50" name="contents">
${detaildto.contents }
</textarea><br>
작성자 : <input type=text name="writer" value="${detaildto.writer }" readonly><br>
조회수 : <input type=text name="viewcount" value="${detaildto.viewcount }" readonly><br>
작성시간 :  <input type=text name="writingtime" value="${detaildto.writingtime}" readonly><br>
<input type=hidden name="pw" value="${detaildto.pw }" ><br>

<input type=button id="updatebtn" value="수정버튼">
<input type=button id="deletebtn" value="삭제버튼">
</form>
</body>
</html>