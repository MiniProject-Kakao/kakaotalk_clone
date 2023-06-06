$(document).ready(function(){
	$('.moveChat').on('click', function(e) {
		$.ajax({
			url : "/createchatroomifnull",
			type : "POST",
			data :  {
				friendId : e.target.id
			},
			success : function(data) {
				location.href = '/chat?chat_list_id=' + data;

			},
			error : function(error){
				console.log(error);
			}
		});
	});
})