    
$(document).ready(function(){
	$('.deleteFriend').on('click', function(e) {
		const ok = window.confirm('삭제하시겠습니까?');

    	if (ok) {			
			$.ajax({
				url : "/deletefriend",
				type : "GET",
				data :  {
					idValue : e.target.id
				},
				success : function(data) {
					location.reload();
				},
				error : function(error){
					console.log(error);
				}
			});
		}
	});
})