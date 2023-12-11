<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<img src="resources/img/${sessionScope.loginCheck.m_photo }" 
	style="max-height: 130px;max-width: 240px;min-height: 130px;min-width: 240px;border-radius: 4px;">
	<table class="memberTable"  align="right">
		<tr>
			<td colspan="2">안녕하세요 ${sessionScope.loginCheck.m_id }님!</td>
		</tr>
		<tr>
			<td><button id="logOutBtn" class="memberBtn">로그아웃</button></td>
			<td><button id="infoBtn" class="memberBtn" >정보수정</button></td>
		</tr>
	</table>
	<br>
	
	
</body>
</html>