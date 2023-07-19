<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> 게시물 리스트를 출력합니다. </h1>
<table border="3">
<tr><th>번호</th><th>제목</th><th>작성자</th><th>조회수</th></tr>
<c:forEach items="${boardList }" var="dto">
	<tr><td>${dto.seq }</td><td><a href='boarddetail?seq=${dto.seq}'>${dto.title }</a></td><td>${dto.writer }</td><td>${dto.viewcount }</td></tr>
</c:forEach>   
</table>

<h3>페이지를 선택하세요 </h3>

<%
  int totalBoard = (Integer)request.getAttribute("totalBoard");
  int totalPage = 0;
  if(totalBoard % 4 == 0){
	  totalPage = totalBoard / 4;
  }
  else{
	  totalPage = totalBoard / 4 + 1;
  }

  for(int i = 1; i <= totalPage; i++){
	  %>
	<a href="boardlist?page=<%=i %>"> <%=i %>페이지 </a>
<%  }
%>
</body>
</html>