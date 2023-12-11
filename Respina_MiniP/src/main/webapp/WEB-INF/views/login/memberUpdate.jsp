<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="submitTbl" border="1" align="center">
		<form name="updateForm" id="updateMember" action="member.update" method="post"
			enctype="multipart/form-data" onsubmit="return updateCheckJS();">
		<tr>
			<td>id</td>
			<td><input name="updateId" class="regInput" placeholder="~10자리"
				maxlength="10"  readonly="readonly"value="${sessionScope.loginCheck.m_id }"></td>
		</tr>
		<tr>
			<td>pw</td>
			<td><input name="updatePw" class="regInput" type="password"
				placeholder="~10자리" maxlength="12"
				value="${sessionScope.loginCheck.m_pw }"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input name="updateName" class="regInput" maxlength="10"
				placeholder="~10자리" value="${sessionScope.loginCheck.m_name }"></td>
		</tr>
		<tr>
			<td>우편번호</td>
			<td><input name="post" id="inputPost" class="regInput"
				maxlength="7" placeholder="xxx-xxx" readonly="readonly"
				value="${post}"></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input name="addr" id="inputAddr" class="regInput"
				maxlength="40" placeholder="주소지" readonly="readonly"
				value="${addr}"></td>
		</tr>
		<tr>
			<td>상세주소</td>
			<td><input name="detail" id="inputDetailAddr"
				maxlength="40" class="regInput" placeholder="상세주소" value="${detail}"></td>
		</tr>
		<tr>
			<td>프로필사진</td>
			<td>
					<img style="max-height: 170px;max-width: 280px;min-height: 170px;
					min-width: 280px;border-radius: 4px;"
					 src="resources/img/${sessionScope.loginCheck.m_photo }"><br>
					<input type="file" id="updateFile" name="updateF"
				accept="image/png, image/jpeg, image/gif"></td>

		</tr>
		<tr>
			<td colspan="2" align="center"><button class="memberBtn">수정
					</button></td>
		</tr>
		</form>
		<tr>
			<td colspan="2" align="center"><button id="deleteMemberBtn" class="memberBtn">탈퇴
					</button></td>
		</tr>
	</table>

</body>
</html>