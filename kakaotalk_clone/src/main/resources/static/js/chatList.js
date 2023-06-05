function goChatRoom() {
	var form = document.createElement("form");
	form.setAttribute("charset","UTF-8");
	form.setAttribute("method","Post");
	form.setAttribute("action", "chat");
	this.appendChild(form);
	
	var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "chat_list_id");
	hiddenField.setAttribute("value", this.id);
	form.appendChild(hiddenField);
	
	form.submit();
}

$(document).ready(function() {
	let crooms = document.querySelectorAll('.croomList');
	crooms.forEach(target => target.addEventListener('click', goChatRoom));
});


