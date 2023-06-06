
//websocket
  var ws;

  function wsOpen(){
  	ws = new WebSocket("ws://" + location.host + "/chatting");
  	$('#chatdiv').scrollTop($('#chatdiv')[0].scrollHeight);
  	wsEvt();
  }
  		
  function wsEvt() {
  	ws.onopen = function(data){
		  
  	}
  		
  	ws.onmessage = function(data) {
  		var msg = data.data;
  		if(msg == "msgok"){
			location.href='/chat?chat_list_id=' + $("#chat_list_id").val();
  		} else if (msg == "img") {
			$("#user_id").val("test123");
			$("#type").val("img");
			$("#content").val("");
			$("#imgform").submit();
			
		}
  	}
  }

	
function send() {
	if($("#imgfile").val() != null) {
		if($("#chatbox").val().length != 0) {
  			var text = $("#chatbox").val().replace(/(?:\r\n|\r|\n)/g, '<br />');
  			var option = {
		  		type: "text",
		  		content: text,
		  		user_id: "test123",
		  		chat_list_id: $("#chat_list_id").val()
	  		};
  			ws.send(JSON.stringify(option));
  			$('#chatbox').val("");
  		}
  	} else {
		  var option = {
		  		type: "img",
		  		content: "",
		  		user_id: "test123",
		  		chat_list_id: $("#chat_list_id").val()
	  		};
  			ws.send(JSON.stringify(option));
	}
};
	
  
  $(document).ready(
	  wsOpen());

//exit
const exit = document.getElementById('exit');
exit.addEventListener('click', goChatList);
function goChatList() {
  location.href = '/chatlist';
}
