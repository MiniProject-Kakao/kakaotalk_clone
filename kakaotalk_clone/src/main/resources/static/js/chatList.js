function goChatRoom() {
  location.href = '/chat';
}


$(document).ready(function() {
	let crooms = document.querySelectorAll('.croomList');
	crooms.forEach(target => target.addEventListener('click', goChatRoom));
});


