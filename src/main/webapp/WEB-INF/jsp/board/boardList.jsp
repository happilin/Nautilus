<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>게시글 목록</title>
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
</head>
<body>
<main>
<h3>게시글 목록</h3>
<table>
<form id="boardList" method="post" action="/board">
<tr><th>글번호</th><th>글제목</th><th>작성자</th><th>작성일</th></tr>
<c:forEach var="b" items="${list}">
	<tr>
		<td>${b.num}</td><td><a href="board/detail/${b.num }">${b.title}</a></td><td>${b.author}</td><td>${b.wdate}</td>
	</tr>
</c:forEach>
</form>
</table>
</main>
<nav>
	[<a href="board/create">글쓰기</a>]
</nav>
<div class="container">
	<div class="row">
		<form method="post" name="search" action="/board/search">
			<table>
				<tr>
					<td><select name="category">
							<option value="0">선택</option>
							<option value="title">제목</option>
							<option value="author">작성자</option>
					</select></td>
					<td><input type="text" 
						placeholder="검색어 입력" name="key" list="list" id="key" maxlength="100"></td>
					<td><button type="submit">검색</button></td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>