const searchIcon = document.getElementById('search_icon');
const searchBox = document.getElementById('search');
const searchList = document.getElementById('search_list');
const searchInput = document.getElementById('search_input');

searchIcon.addEventListener('click', createInput);
function createInput() {
  if (searchBox.style.display === 'none') {
    searchBox.style.display = 'flex';
    searchInput.focus();
  } else {
    searchBox.style.display = 'none';
    searchInput.value = '';
    searchList.style.display = 'none';
    listBox.style.display = 'block';
  }
}



searchInput.addEventListener('keyup', debounce);
const listBox = document.getElementById('list_box');

function debounce(e) {
  let timer;

  timer = setTimeout(function () {
    const { value } = e.target;

    if (value.length > 0) {
      let friends_filter = friend_arr.filter(ele => {
        const name = ele.name.toLowerCase();
        return name.includes(value);
      });

      if (friends_filter.length > 0) {
        searchList.style.display = 'block';
        listBox.style.display = 'none';
      } else {
        searchList.style.display = 'none';
        listBox.style.display = 'block';
      }
      return (searchList.innerHTML = friends_filter
        .map(
          el => `<li>
          <div class="profile_img">
            <img
              src="${el.profile_image}"
              onerror="this.onerror=null; this.src='../img/profile.svg';"
              />
          </div>
          <div class="detail">
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
            ${el.status_message != '' ? `<p>${el.status_message}</p>` : ''}
          </div>
          <ul id="bookmark">
            <li id="${el.id}" class="updateFollow" value="${el.follow ? '1' : '0'}">⭐</li>
            <li>💬</li>
          </ul>
        </li>`
        )
        .join(''));
    } else {
      searchList.style.display = 'none';
      listBox.style.display = 'block';
    }
  }, 300);
}