
//websocket
  var ws;

  function wsOpen(){
  	ws = new WebSocket("ws://" + location.host + "/chatting");
  	wsEvt();
  }
  		
  function wsEvt() {
  	ws.onopen = function(data){
		  
  	}
  		
  	ws.onmessage = function(data) {
  		var msg = data.data;
  		if(msg != null && msg.trim() != ''){
			var d = JSON.parse(msg);
  			$("#chat").append("<li class='chatStyleMe'><div><div><p>" + d.msg + "</p></div></div></li>");
  			$('#chatdiv').scrollTop($('#chatdiv')[0].scrollHeight);
  		}
  	}
  }

	
  function send() {
  	var text = $("#chatbox").val().replace(/(?:\r\n|\r|\n)/g, '<br />');
  	var option = {
		  type: "text",
		  msg: text
	  };
  	ws.send(JSON.stringify(option));
  	$('#chatbox').val("");
  }
  
  $(document).ready(wsOpen());

//exit
const exit = document.getElementById('exit');
exit.addEventListener('click', goChatList);
function goChatList() {
  location.href = '/chatlist';
}
