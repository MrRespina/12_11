<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- boardVal =all 일때, 전체 / boardVal =my 일때 내 게시글 확인만 되게끔! -->
	<c:if test="${boardVal eq 'all' }">
	<table align="center">
		<tr>
			<td><c:if test="${pageNo != 1}">
					<a href="board.go?p=${pageNo - 1 }"  class="boardL">&lt;</a>
				</c:if> <c:if test="${pageNo != pageCount}">
					<a href="board.go?p=${pageNo + 1 }"  class="boardR">&gt;</a>
				</c:if></td>
		</tr>
	</table>
	</c:if>
	<c:if test="${boardVal eq 'my' }">
	<table align="center">
		<tr>
			<td><c:if test="${pageNo2 != 1}">
					<a href="board.getmyBoard?p=${pageNo2 - 1 }"  class="boardL">&lt;</a>
				</c:if> 
				<c:if test="${pageNo2 != pageCount2}">
					<a href="board.getmyBoard?p=${pageNo2 + 1 }"  class="boardR">&gt;</a>
				</c:if>
				</td>
		</tr>
	</table>
	</c:if>
	<div style="height: 660px;">
	<c:forEach var="board" items="${boards}">
		<form name="boardf">
		<table class="boardContent" align="center">
			<tr>
				<td rowspan="2" align="center">${board.b_owner}<br>
				</td>
				<td align="right" class="boardWhen">
				<input id="b_no" value="${board.b_no }" type="hidden"> 
				<input id="b_owner" value="${board.b_owner }" type="hidden">			
				<input id="b_when" value="${board.b_when }" type="hidden">			
				<fmt:formatDate
					value="${board.b_when }" type="both" dateStyle="long"
				timeStyle="short" />
				</td>
			</tr>
			<tr>
				<td class="boardText"><textarea id="b_text" class="boardText" 
						readonly="readonly" value="${board.b_text}">${board.b_text}</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
				<c:if test="${board.b_owner == sessionScope.loginCheck.m_id }">
						<div>
							<span class="infoClass">
							수정하기<img style="width: 30px; height: 30px;"
								src="resources/img/repair.png">
							</span>
						</div>
					</c:if>
				<c:if test="${board.b_owner != sessionScope.loginCheck.m_id
					 and not empty sessionScope.loginCheck.m_id}">
						<div >
							댓글 달기<img style="width: 30px; height: 30px;"
								src="resources/img/com_icon.png">
						</div>
					</c:if> 
					
					</td>
			</tr>
		</table>
	</form>
	</c:forEach>
	</div>

</body>
</html>