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
	<form name="infoForm">
	<table class="infoBoard" align="center">
		<tr>
			<td align="center" colspan="3">게시글 수정하기</td>
		</tr>
		<tr>
			<td>
			<input name="b_no" value="${b_no }" type="hidden"> 
			<input name="b_owner" value="${b_owner }" type="hidden"></td>
		</tr>
		<tr>
			<td colspan="3"><textarea class=infoText name="b_text"></textarea></td>
		</tr>
		<tr>
			<td colspan="1">
				<Button class="updateInfo">수정</Button>
			</td>
			<td colspan="1">
				<Button class="deleteInfo">삭제</Button>
			</td>
			<td colspan="1">
				<Button class="getBack">돌아가기</Button>
			</td>
		</tr>
	
	</table>
	</form>
</body>
</html>