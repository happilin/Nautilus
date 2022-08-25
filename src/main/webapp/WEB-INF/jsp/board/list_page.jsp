<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>페이지별 목록보기</title>
<style type="text/css">
	main { width:fit-content; margin:0 auto; }
	main>h3 { width:fit-content; margin:1em auto; border-bottom:3px double black;}
	table { width:fit-content; padding:1em; border-spacing:0; border-collapse:collapse;
			border:1px solid black; }
	th,td { padding:0.3em 1em; border-right:1px dashed black;}
	th { border-bottom:3px double black; background-color:#fee;}
	th:last-child {border-right:none;}
	td:last-child {border-right:none;, border-bottom:none;}
	td { border-bottom:1px dashed black; }
	tr:nth-child(odd)>td { background-color:#dff;}
	nav { width:fit-content; margin:1em auto; background-color:#adf;}
	nav>a { display:inline-block; text-decoration:none; width:2em; text-align: center;}
	nav>a.currPage { border:1px solid black;}
	a { text-decoration:none;}
</style>
</head>
<body>
<main>
<h3>페이지별 목록보기</h3>
<table>
<tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th></tr>
<c:forEach var="m" items="${pageInfo.list}">
	<tr>
		<td>${m.num}</td>
		<td><a href="board/detail/${b.num }">${m.title}</a></td>
		<td>${m.author}</td>
		<td>${m.wdate}</td>
	</tr>
</c:forEach>
</table>
<nav>
	<c:forEach var="i" items="${pageInfo.navigatepageNums}">
		<c:choose>
			<c:when test="${i==pageInfo.pageNum }">
			[${i }]
			</c:when>
			<c:otherwise>
			[<a href="/jdbc/board/page/${i}">${i }</a>]
			</c:otherwise>		
		</c:choose>
	</c:forEach>
</nav>
</main>
</body>
</html>