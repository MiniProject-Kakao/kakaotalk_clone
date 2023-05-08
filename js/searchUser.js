const searchIcon = document.getElementById('search_icon');
const search = document.getElementById('search');
const searchInput = document.getElementById('searchInput');

searchIcon.addEventListener('click', createInput);

function createInput() {
  if (search.style.display === 'none') {
    search.style.display = 'flex';
    searchInput.focus();
  } else {
    search.style.display = 'none';
    searchInput.value = '';
  }
}
