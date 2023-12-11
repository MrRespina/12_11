<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<img src="resources/img/lion.gif"
				style="max-height: 120px; max-width: 120px; min-height: 120px; min-width: 120px; border-radius: 4px;">
	<table class="memberTable" align="right" >
	<form name="loginForm" action="member.login" method="post">
		<tr>
			<td>id</td>
			<td><input name="m_id" id="inputId" class="memberInput" maxlength="10"
				placeholder="~10자 까지"></td>
			<td><button id="loginBtn" class="memberBtn">로그인</button></td>
		</tr>
		<tr>
			
			<td>pw</td>
			<td><input name="m_pw" id="inputPw" class="memberInput" type="password"
				maxlength="10" placeholder="~10자 까지"></td>
	</form>
			<td><button id="regMemberBtn" class="memberBtn">회원가입</button></td>
		</tr>
	</table>

</body>
</html>