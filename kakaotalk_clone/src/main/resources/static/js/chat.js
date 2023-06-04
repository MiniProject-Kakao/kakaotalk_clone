//interlocutor
document.getElementById('il').innerHTML += `<li>
      <div><img src=${interlocutor.il_icon_url} alt='usericon'/></div>
      <div>
          <p>${interlocutor.il_name}</p>
      </div>
  </li>`;


/*
//chatting
let temp_name = '';

document.getElementById('chat').innerHTML += chatlog
  .map(function (el) {
    let result = `<li class='chatStyleli'>
              <div>
                  <img src=${el.chatter_icon_url} alt='usericon'/>
              </div>
              <div><p>${el.chatter_name}</p>
              <div>
                  <p>${el.chat_data}</p>
              </div>`;
    if (temp_name == '') {
      temp_name = el.chatter_name;
      if (el.chatter_name != 'me') {
        return result;
      } else if (el.chatter_name == 'me') {
        return `<li class='chatStyleMe'>
          <div>
            <div>
              <p>${el.chat_data}</p>
            </div>`;
      }
    } else if (temp_name == el.chatter_name) {
      if (!el.isLast && el.chatter_name != 'me') {
        return `<div><p>${el.chat_data}</p></div>`;
      } else if (!el.isLast && el.chatter_name == 'me') {
        return `<div><p>${el.chat_data}</p></div>`;
      } else if (el.isLast && el.chatter_name != 'me') {
        return `<div><p>${el.chat_data}</p></div></div></li>`;
      } else if (el.isLast && el.chatter_name == 'me') {
        return `<div><p>${el.chat_data}</p></div></div></li>`;
      }
    } else if (temp_name != el.chatter_name && el.chatter_name != 'me') {
      temp_name = el.chatter_name;
      if (!el.isLast) {
        return `</div></li>` + result;
      } else {
        return (
          `</div></li>` +
          result +
          `<div><p>${el.chat_data}</p></div></div></li>`
        );
      }
    } else if (temp_name != el.chatter_name && el.chatter_name == 'me') {
      temp_name = el.chatter_name;
      if (!el.isLast) {
        return `</div></li>
          <li class='chatStyleMe'>
          <div>
            <div>
              <p>${el.chat_data}</p>
            </div>`;
      } else {
        return `</div></li><div><p>${el.chat_data}</p></div></div></li>`;
      }
    }
  })
  .join('');

*/

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
  			$("#chat").append("<li class='chatStyleMe'><div><div><p>" + msg + "</p></div></div></li>");
  			$('#chatdiv').scrollTop($('#chatdiv')[0].scrollHeight);
  		}
  	}
  }

	
  function send() {
  	var msg = $("#chatbox").val();
  	msg = msg.replace(/(?:\r\n|\r|\n)/g, '<br />');
  	ws.send(msg);
  	$('#chatbox').val("");
  }
  
  $(document).ready(wsOpen());

//exit
const exit = document.getElementById('exit');
exit.addEventListener('click', goChatList);
function goChatList() {
  location.href = '/chatlist';
}