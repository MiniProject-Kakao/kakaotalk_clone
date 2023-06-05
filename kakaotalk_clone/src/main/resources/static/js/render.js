$(document).ready(function(){
	
	let param = document.location.href.split("=");
	
	if(param[1] == "0") {
		alert("친구등록이 완료되었습니다.");
		location.href = "/home";
	} else if (param[1] == "1") {
		alert("친구를 찾을 수 없습니다.");
		location.href = "/home";
	} else if (param[1] == "2") {
		alert("등록된 친구입니다.");
		location.href = "/home";
	} else if (param[1] == "3") {
		alert("등록에 실패했습니다");
		location.href = "/home";
	}
	
	$('.updateFollow').on('click', function(e) {
		$.ajax({
			url : "/home",
			type : "POST",
			async: false,
			data :  {
				follow : e.target.value,
				idValue : e.target.id
			},
			success : function(data) {
				location.reload();
			},
			error : function(error){
				console.log(error);
			}
		});
	});
})