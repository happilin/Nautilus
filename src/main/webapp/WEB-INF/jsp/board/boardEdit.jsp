<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 수정 폼</title>
<style type="text/css">
	main { width:fit-content; margin:0 auto;}
	main>h3 { width:fit-content; margin:1em auto; border-bottom:3px double black;}
	form {padding:1em; border:1px solid black; border-radius:7px;}
	div>label { display:inline-block; width:2em; padding-right:1em; text-align:right; vertical-align:top;  }
	div>input {width:30em; margin-bottom:0.5em; }
	div>textarea { width:30em; height:10em; }
	form>div:last-child { margin:1em auto; margin-bottom:0; width:fit-content; text-align:center;}
	nav { width:fit-content; margin:1em auto; }
	nav > a { text-decoration:none; }
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script type="text/javascript">

function update(){

	
	
	$.ajax({
	    url:'/board/update',	
		method:'post',
		cache:false,
		data:$('#edit_form').serialize(),
		dataType:'json',
		success:function(res){
		    alert(res.updated ? '수정 성공': 'Failed');
			location.href='/board/detail/${board.num}';
		},
	    error:function(xhr,status,err){
	       alert('Error:'+err);
		}
	});
	return false;
}
/*
function edit() {
    $.ajax({
       url:'/board/update',
       method:'post',
       cache:false,
       data:$('#edit_form').serialize(),
       dataType:'json',
       success:function(res){ //res는 object
             alert(res.updated ? '수정 성공' : '수정실패'); //res object 안에있는 num
             //location.href="/board/list";
       },
       error:function(xhr,status,err){
          alert(err);
       }
    });
    return false;
 }*/
</script>

</head>
<body>
<h3>게시판 글 수정 폼</h3>
<form id="edit_form" onsubmit="return update();">
	<!--  <input type="hidden" name="cmd" value="add">-->
	<input type="hidden" name="num" id="num" value="${board.num }">
	<input type="hidden" name="pcode" value="${board.pcode}"><!-- 영역객체 -->
	<div>
		<input type="text" name="author" value="${board.author }" readonly>
		<label for="author">작성자</label>
	</div>
	<div>
	<input type="text" name="wdate" value="${board.wdate }" readonly>
		<label for="wdate">작성일</label>
	</div>
	<div>
	
		<label for="title">제목</label> <input type="text" name="title" id="title" value="${board.title }">
	</div>
	<div>
		<label for="contents">내용</label>
		<textarea id="contents" name="contents" value="${board.contents}">${board.contents }</textarea>
	</div>
	<div>
		<button type="reset">취소</button>
		<button type="submit">저장</button>
	</div>
</form>
</body>
</html>