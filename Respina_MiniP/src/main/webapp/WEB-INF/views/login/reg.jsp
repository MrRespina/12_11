<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="regForm" id="regMember" action="member.signup.reg"  onsubmit="return signUpCheckJS();"
	method="post" enctype="multipart/form-data">
		<table class="submitTbl" border="1" align="center">
			<tr>
				<td>id</td>
				<td><input name="inputId" class="regInput" placeholder="~10자리"
					maxlength="10"></td>
			</tr>
			<tr>
				<td>pw</td>
				<td><input name="inputPw" class="regInput" type="password"
					placeholder="~10자리" maxlength="12"></td>
			</tr>
			<tr>
				<td>pw 확인</td>
				<td><input name="checkPw" class="regInput" type="password"
					placeholder="~10자리" maxlength="12"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input name="inputName" class="regInput" maxlength="10"
					placeholder="~10자리"></td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td><input name="inputPost" id="inputPost" class="regInput" maxlength="7"
					placeholder="xxx-xxx" readonly="readonly"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input name="inputAddr" id="inputAddr" class="regInput" maxlength="40"
					placeholder="주소지" readonly="readonly"></td>
			</tr>
			<tr>
				<td>상세주소</td>
				<td><input name="inputDetailAddr" id="inputDetailAddr" maxlength="40" class="regInput"
					placeholder="상세주소" ></td>
			</tr>
			<tr>
				<td>프로필사진</td>
				<td><input type="file" id="inputFile" name="inputFile" accept="image/png, image/jpeg, image/gif"></td>
			</tr>
			<tr>
				<td>권한등급</td>
				<td><input type="radio" name="inputClass" id="manager" value="1">관리자
						<input type="radio" name="inputClass" id="normal" value="0" checked>일반
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><button id="regBtn" class="memberBtn">입력
						완료</button></td>
			</tr>

		</table>
	</form>
</body>
</html>