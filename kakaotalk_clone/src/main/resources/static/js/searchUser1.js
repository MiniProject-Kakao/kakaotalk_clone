const searchIcon = document.getElementById('search_icon');
const searchBox = document.getElementById('search');
const searchList = document.getElementById('search_list');
const searchInput = document.getElementById('search_input');

searchIcon.addEventListener('click', createInput);
function createInput() {
  if (searchBox.classList.contains('hide_content')) {
    searchBox.classList.remove('hide_content');
    searchInput.focus();
  } else {
    searchBox.classList.add('hide_content');
    searchList.classList.add('hide_content');
    searchInput.value = '';
    listBox.style.display = 'block';
  }
}

searchInput.addEventListener('keyup', debounce);
const listBox = document.getElementById('list_box');

function debounce(e) {
  const { value } = e.target;

  if (value.length > 0) {
    searchList.classList.remove('hide_content');
    listBox.style.display = 'none';
  } else {
    searchList.classList.add('hide_content');
    listBox.style.display = 'block';
  }
}
