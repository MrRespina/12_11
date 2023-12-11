$(function() {

	boards();

});

function boards() {

	$('.infoClass').click(
			function() {

				// 부모 테이블 (boardContent) 에서 input의 id로 찾아라.
				let b_no = $(this).closest("table.boardContent").find(
						"input[id='b_no']").val();
				let b_owner = $(this).closest("table.boardContent").find(
						"input[id='b_owner']").val();
				let b_when = $(this).closest("table.boardContent").find(
						"input[id='b_when']").val();
				let b_text = $(this).closest("table.boardContent").find(
						"textarea[id='b_text']").val();

				location.href = "board.boardInfo?b_no=" + b_no + "&b_owner="
						+ b_owner + "&b_when=" + b_when + "&b_text=" + b_text;

			});

	$('.getBack').click(function() {

		if (confirm('돌아가시겠어요?')) {

			location.href = "board.go";

		}

	});

}

