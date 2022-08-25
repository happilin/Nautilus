<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PageHelper를 이용한 Pagination 예제</title>
<style type="text/css">
	main { width:fit-content; padding:1em; margin:0 auto; }
	main>h3 { width:fit-content; margin:1em auto; border-bottom:3px double black; }
	table { border-spacing:0; border-collapse:collapse; border:1px solid black;}
	th { border-bottom:3px double black; background-color:#eee; border-right:1px solid black;}
	th:last-child { border-right:none; }
	td { border-bottom: 1px dashed black; border-right:1px dashed black; padding:0.3em 1em;}
	td:last-child { border-right:none; }
	tr:last-child>td { border-bottom:none; }
	nav,div { width:fit-content; margin:1em auto; }
	nav > a { text-decoration:none; }
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script type="text/javascript">
function search(page){
	$('#page').val(page);
	$('#search_form').submit();
}
</script>

</head>
<body>
<main>
<h3>페이지별 검색 결과 목록보기</h3>
<table>
<tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th></tr>
<c:forEach var="b" items="${pageInfo.list}">
	<tr>
		<td>${b.num}</td><td><a href="board/detail/${b.num }">${b.title}</a></td><td>${b.author}</td><td>${b.wdate}</td>
	</tr>
</c:forEach>
</table>
<nav>
<c:forEach var="i" items="${pageInfo.navigatepageNums }">
	<c:choose>
		<c:when test="${pageInfo.navigatepageNums }">
			<span id="currpage">[${i }]</span>
		</c:when>
		<c:otherwise>
			[<a href="javascript:search(${i });">${i }</a>]
		</c:otherwise>
	</c:choose>
</c:forEach>
</nav>
</main>
<div id="search">
<form id="search_form" method="post" action="/jdbc/board/search">
	<input type="hidden" id="psize" name="psize" value="5">
	<input type="hidden" id="page" name="page" value="1">
	<div>
		<label for="category">검색항목</label>
		<select name="category">
			<option value="author" <c:if test="${category=='author' }">selected</c:if>>작성자</option>
			<option value="title" <c:if test="${category=='title' }">selected</c:if>>글제목</option>
			<option value="contents" <c:if test="${category=='contents' }">selected</c:if>>글내용</option>
		</select>
		<label for="keyword">검색어</label>
		<input type="text" name="keyword" value="${keyword }">
	</div>
	<div id="btn">
		<button type="reset">취소</button>
		<button type="submit">검색</button>
	</div>
</form>
</div>
<nav>
	[<a href="board/create">글쓰기</a>]
</nav>
</body>
</html>