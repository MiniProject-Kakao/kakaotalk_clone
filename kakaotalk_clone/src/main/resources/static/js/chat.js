
//websocket
  var ws;

  function wsOpen(){
  	ws = new WebSocket("ws://" + location.host + "/chatting");
  	$("#file1").val() == null;
  	setTimeout(() => $('#chatdiv').scrollTop($('#chatdiv')[0].scrollHeight), 100);
  	wsEvt();
  }
  		
  function wsEvt() {
  	ws.onopen = function(data){
		  
  	}
  		
  	ws.onmessage = function(data) {
  		var msg = data.data;
  		if(msg == "msgok"){
			location.href='/chat?chat_list_id=' + $("#chat_list_id").val();
			$('#chatdiv').scrollTop($('#chatdiv')[0].scrollHeight);
  		} else {
			var condition = msg.slice(4);
			if(sessionid == condition) {
			$("#user_id").val(sessionid);
			$("#type").val("img");
			$("#content").val("");
			$("#imgform").submit();
			$('#chatdiv').scrollTop($('#chatdiv')[0].scrollHeight);
			} else {
				setTimeout(() => location.href='/chat?chat_list_id=' + $("#chat_list_id").val(), 1500);
			}
		}
  	}
  }

	
function send() {
	if($("#file1").val() == "") {
		if($("#chatbox").val().length != 0) {
  			var text = $("#chatbox").val().replace(/(?:\r\n|\r|\n)/g, '<br />');
  			var option = {
		  		type: "text",
		  		content: text,
		  		user_id: sessionid,
		  		chat_list_id: $("#chat_list_id").val()
	  		};
  			ws.send(JSON.stringify(option));
  			$('#chatbox').val("");
  		}
  	} else {
		  var option = {
		  		type: "img",
		  		content: "",
		  		user_id: sessionid,
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
