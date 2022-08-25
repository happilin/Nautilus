<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>게시판 글 상세보기</title>
<style type="text/css">
   main { width:fit-content; margin:1em auto; background-color:#eee; padding:1em; }
   .container>div { width:500px; border-bottom:1px solid black; }
   main>h3 { width:fit-content; margin:1em auto; }
   label { display:inline-block; width:3em; padding:0.3em 1em;}
   #contents { display:inline-block; width:400px; height:100px; padding-left:0;}
   div:last-child>label {vertical-align: top; padding-top:2em;}
   nav {width:fit-content; margin:1em auto;}
   nav>a { text-decoration:none; }
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script type="text/javascript">
function  deleteBoard(){
   alert("deleteBoard();");
   if(!confirm('정말로 삭제하시겠습니까?'))return;
   $.ajax({
      url:'/board/delete/${board.num}',
      cache:false,
      method:'get',
      dataType:'json',
      success: function(res){
         	//alert(res);
            alert(res.deleted? '삭제성공':'삭제실패');
            if(res.deleted){
               location.href="/board";
            }
      
      },
      error: function(xhr,status,err){
         alert('Error:' + err);
      }
   });
   }
</script>
</head>
<body>
<main>
<h3>게시판 글 상세보기</h3>
<div class="container">
   <div><label>글번호</label><span>${board.num}</span></div>
   <div><label>글제목</label><span>${board.title}</span></div>
   <div><label>작성자</label><span>${board.author}</span></div>
   <div><label>작성일</label><span>${board.wdate}</span></div>
   <div><label>부모글</label><span>${board.pcode}</span></div>
   <div><label>글내용</label>
      <div id="contents">${board.contents}</div>
   </div>
</div>
</main>
<nav>
   [<a href="/board">전체 목록</a>]
   <!--[<a href="javascript:history.back(-1);">이전 목록보기</a>]-->
   [<a href="board?cmd=input_form&pcode=${board.num}">답글쓰기</a>]
   <!--[<a href="/jdbc/board/edit/${board.num }">수정하기</a>]-->
   [<a href="/board/edit/${board.num }">수정하기</a>]
   [<a href="javascript:deleteBoard();">삭제하기</a>]
</nav>
</body>
</html>