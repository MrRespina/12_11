<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/member/memberCheck.js"></script>
<script type="text/javascript" src="resources/js/member/member.js"></script>
<script type="text/javascript" src="resources/js/board/board.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" href="resources/css/main.css">
<link rel="stylesheet" href="resources/css/login.css">
<link rel="stylesheet" href="resources/css/board.css">
<link rel ="stylesheet" href="resources/css/side.css">
</head>
<body class="indexBody">
<c:if test="${not empty sessionScope.loginCheck.m_id}">
<aside class="side-bar">
  <section class="side-bar__icon-box">
    <section class="side-bar__icon-1">
      <div></div>
      <div></div>
      <div></div>
    </section>
  </section>
  <ul>
  
    <li>
      <a href="#"><i class="fa-solid fa-cat"></i> 글쓰기</a>
      <ul style="width:407px;background-color:rgba(255,255,255,0.2);border-radius: 5px;border:black dashed 2px;">
        <li align="center">
        	<form action="board.writeBoard">
        	<input name="token" value="${token }" type="hidden">
        	<textarea class="boardText" name="write_board" ></textarea><br>
        	<button style="width:45px;height:35px;">
        		<img src="resources/img/com_icon.png" style="width:30px;height:30px;">
        	</button>
        	</form>
        </li>   
      </ul>
    </li>
   
    <li>
      <a href="#">검색</a>
      <ul style="width:265px;background-color:rgba(255,255,255,0.2);border-radius: 5px;border:black dashed 2px;">
        <li align="center"><input class="searchInput" name="search_board"><br>
        	<img style="width:30px;height:30px;" src="resources/img/magnifier.png">
        </li>
      </ul>
    </li>
    <li>
    	<a href="board.getmyBoard?">내 글 보기</a>
    </li>
    <li>
    	<a href="board.go?">전체 글 보기</a>
    </li>

  </ul>
</aside>	
</c:if>

	<table class="indexTbl" align="center">
		<tr class="tr1">
			<td class="indexTd" colspan="2">Respina's 미니프로젝트
			</td>
			<td class="indexTd" colspan="1">${result}</td>
		</tr>
		<tr class ="tr2">
			<td class="indexTd" colspan="1">
				<img src="resources/img/home2.png"  onclick="javascript:location.href='/springP001/'"
			style="max-height: 50px;max-width: 50px;">&nbsp;&nbsp;&nbsp;&nbsp;
				<img src="resources/img/startup.png"  onclick="javascript:location.href='board.go'"
			style="max-height: 50px;max-width: 50px;">
			
			
			</td>
			<td class="indexTd" colspan="1">뭘 넣을까?</td>
			<td class="indexTd" colspan="1"><jsp:include page="${log}"/></td>
		</tr>
		
		<tr class="contentTr">
			<td colspan="6"><jsp:include page="${content}"/></td>
		</tr>

	</table>

</body>
</html>