const searchIcon = document.getElementById('search_icon');
const searchBox = document.getElementById('search');
const searchList = document.getElementById('searchList');
const searchInput = document.getElementById('searchInput');

searchIcon.addEventListener('click', createInput);
function createInput() {
  if (searchBox.style.display === 'none') {
    searchBox.style.display = 'flex';
    searchInput.focus();
  } else {
    searchBox.style.display = 'none';
    searchInput.value = '';
  }
}

searchInput.addEventListener('keyup', debounce);
const listBox = document.getElementById('listBox');

function debounce(e) {
  let timer;

  timer = setTimeout(function () {
    const { value } = e.target;

    if (value.length > 0) {
      let friend_filter = friend.filter(ele => {
        const temp = ele.name.toLowerCase();
        return temp.includes(value);
      });

      if (friend_filter.length > 0) {
        searchList.style.display = 'block';
        listBox.style.display = 'none';
      } else {
        searchList.style.display = 'none';
        listBox.style.display = 'block';
      }
      return (searchList.innerHTML = friend_filter
        .map(
          el => `<li>
          <div><img src=${el.icon_url} /></div>
          <div>
            <p>${el.name
              .replaceAll(value, `@#$%${value}@#$%`)
              .split('@#$%')
              .map(
                keyword =>
                  `<span style='font-weight: ${
                    keyword === value ? 'bold' : ''
                  }'>${keyword}</span>`
              )
              .join('')}</p>
            ${el.value.length != 0 ? `<p>${el.value}</p>` : ''}
          </div>
        </li>`
        )
        .join(''));
    } else {
      searchList.style.display = 'none';
      listBox.style.display = 'block';
    }
  }, 300);
}