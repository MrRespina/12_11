// 예외처리용 함수 모음집
function isEmpty(input) {
	return (!input.value);
}

function containsAnother(input) {
	let pass = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXDYZ0123456789";
	let iv = input.value;
	for (let i = 0; i < iv.length; i++) {
		if (pass.indexOf(iv[i]) == -1) {
			return true;
		}
	}
	return false;
}

function notEqualPw(input1, input2) {
	return (input1.value !== input2.value);
}

function isNotType(input, type) {
	type = "." + type;
	return (input.value.indexOf(type) == -1);
}

// 로그인 체크
function loginCheckJS() {

	let m_id = document.loginForm.m_id;
	let m_pw = document.loginForm.m_pw;

	if (isEmpty(m_id)) {
		m_id.value = "";
		alert('id를 입력해주세요!');
		return false;
	} else if (containsAnother(m_id)) {
		m_id.value = "";
		alert('id에 특수문자와 한글은 사용할 수 없습니다.');
		return false;
	} else if (isEmpty(m_pw)) {
		m_pw.value = "";
		alert('password를 입력해주세요!');
		return false;
	}
	return true;
}

// 가입용
function signUpCheckJS() {

	let s_id = document.regForm.inputId;
	let s_pw = document.regForm.inputPw;
	let s_pw_check = document.regForm.checkPw;
	let s_name = document.regForm.inputName;
	let s_post = document.regForm.inputPost;
	let s_detail = document.regForm.inputDetailAddr;
	let s_photo = document.regForm.inputFile;
	let s_class = document.regForm.inputClass;

	if (isEmpty(s_id)) {
		s_id.value = "";
		s_id.focus();
		alert('id를 입력해주세요!');
		return false;
	} else if (isEmpty(s_pw)) {
		s_pw.value = "";
		s_pw.focus();
		alert('pw를 입력해주세요!');
		return false;
	} else if (isEmpty(s_pw_check)) {
		s_pw_check.value = "";
		s_pw_check.focus();
		alert('pw체크를 입력해주세요!');
		return false;
	} else if (isEmpty(s_name)) {
		s_name.value = "";
		s_name.focus();
		alert('이름을 입력해주세요!');
		return false;
	} else if (isEmpty(s_post)) {
		s_post.value = "";
		s_post.focus();
		alert('주소를 입력해주세요!');
		return false;
	} else if (isEmpty(s_detail)) {
		s_detail.value = "";
		s_detail.focus();
		alert('상세주소를 입력해주세요!');
		return false;
	} else if (isEmpty(s_photo)) {
		s_photo.value = "";
		s_photo.focus();
		alert('프로필 사진을 등록해주세요!');
		return false;
	} else if (containsAnother(s_id)) {
		s_id.value = "";
		s_id.focus();
		alert('id는 영문/숫자만 입력해주세요!');
		return false;
	} else if (containsAnother(s_pw)) {
		s_pw.value = "";
		s_pw.focus();
		alert('pw는 영문/숫자만 입력해주세요!');
		return false;
	} else if (notEqualPw(s_pw, s_pw_check)) {
		s_pw_check.value = "";
		s_pw_check.focus();
		alert('pw와 pw 확인이 다릅니다!');
		return false;
	} else if (isNotType(s_photo, 'png') && isNotType(s_photo, 'jpg')
			&& isNotType(s_photo, 'gif')) {
		s_photo.value = "";
		s_photo.focus();
		alert('프로필 사진은\n [ .png , .jpg , .gif ] \n만 등록이 가능합니다!');
		return false;
	}
	return true;
}

// 업데이트용
function updateCheckJS() {

	let u_pw = document.updateForm.updatePw;
	let u_name = document.updateForm.updateName;
	let u_detail = document.updateForm.detail;
	let u_photo = document.updateForm.updateFile;

	if (isEmpty(u_pw)) {
		u_pw.value = "";
		u_pw.focus();
		alert('pw를 입력해주세요!');
		return false;
	} else if (isEmpty(u_name)) {
		u_name.value = "";
		u_name.focus();
		alert('이름을 입력해주세요!');
		return false;
	} else if (isEmpty(u_detail)) {
		u_detail.value = "";
		u_detail.focus();
		alert('상세주소를 입력해주세요!');
		return false;
	} else if (containsAnother(u_pw)) {
		u_pw.value = "";
		u_pw.focus();
		alert('pw는 영문/숫자만 입력해주세요!');
		return false;
	} else {
		if (isEmpty(u_photo)) {
			return true;
		} else {
			if (isNotType(u_photo, 'png') && isNotType(u_photo, 'jpg')
					&& isNotType(u_photo, 'gif')) {
				u_photo.value = "";
				u_photo.focus();
				alert('프로필 사진은\n [ .png , .jpg , .gif ] \n만 등록이 가능합니다!');
				return false;				
			}		
		}
	}
}
