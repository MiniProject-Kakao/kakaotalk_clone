const searchChatList = document.getElementById('searchChatList');
const searchBox = document.getElementById('search');
const searchInput = document.getElementById('searchInput');

searchChatList.addEventListener('click', createInput);
function createInput() {
  if (searchBox.style.display === 'none') {
    searchBox.style.display = 'flex';
    searchInput.focus();
  } else {
    searchBox.style.display = 'none';
    searchInput.value = '';
  }
}
