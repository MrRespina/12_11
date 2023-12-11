$(function() {

	member();
	searchAddress();

});

function member() {

	$('#loginBtn').click(function(e) {
		
		if(loginCheckJS()==true){
			
			location.href = "member.login?m_id=" + id + "&m_pw=" + pw;
			
		}

	});

	$('#regMemberBtn').click(function(e) {

		location.href = "member.signup?";	
		
	});

	$('#logOutBtn').click(function() {

		if (confirm('정말 로그아웃 하시겠어요?')) {

			location.href = "member.logout?";

		}

	});
	
	$('#infoBtn').click(function() {

			location.href = "member.info?";

	});
	
	$('#deleteMemberBtn').click(function(){
		
		if(confirm('정말 탈퇴하시겠습니까?\n삭제된 정보는 복구되지 않습니다.')){
			
			location.href = "member.leave?";
			
		}	
		
	});

}
function searchAddress() {

	$('#inputAddr,#inputPost').click(function() {

		new daum.Postcode({
			oncomplete : function(data) {
				$('#inputPost').val(data.zonecode);
				$('#inputAddr').val(data.roadAddress);
			}

		}).open();

	});

}
