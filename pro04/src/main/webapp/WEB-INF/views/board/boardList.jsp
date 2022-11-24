<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path1" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>공지사항 목록</title>
    <jsp:include page="../include/head.jsp" />
</head>
<body>
<header class="">
	<jsp:include page="../include/header.jsp" />
</header>
    <div class="row column text-center">
      <h2>공지사항 목록</h2>
      <hr>
      <table>
      	<thead>
      		<tr>
      			<th width="80">번호</th>
      			<th>제목</th>
      			<th width="150">작성일</th>
      			<th>조회수</th>
      		</tr>
      	</thead>
      	<tbody>
      	<c:forEach items="${boardList }" var="board" varStatus="status">
      		<tr>
      			<td>${status.count }</td>
      			<td><a href="/board/detail.do?seq=${board.seq }">${board.title }</a></td>
      			<td>${board.regdate }</td>
      			<td>${board.visited }</td>
      		</tr>
      	</c:forEach>	
      	</tbody>
      </table>
      	<div class="button-group">
  			<a href="${path1 }/boardInsertForm.do" class="button">글 등록</a>
		</div>
    </div>
	
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.js"></script>
    <script>
      $(document).foundation();
    </script>
</body>
</html>