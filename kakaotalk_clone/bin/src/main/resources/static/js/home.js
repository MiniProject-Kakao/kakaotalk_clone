document.getElementById('user').innerHTML += `
  <div>
    <img
      src="${user.icon_url}"
      onerror="this.onerror=null; this.src='../img/profile.svg';"
    />
  </div>
  <div>
    <p>${user.name}</p>
    ${user.value.length != 0 ? `<p>${user.value}</p>` : ''}
  </div>`;

document.getElementById('like').innerHTML += friend
  .map(el =>
    el.like
      ? `<li>
        <div class="profile_img">
          <img
            src="${el.icon_url}"
            onerror="this.onerror=null; this.src='../img/profile.svg';"
          />
        </div>
        <div class="detail">
          <p>${el.name}</p>
          ${el.value.length != 0 ? `<p>${el.value}</p>` : ''}
        </div>
        <ul id="bookmark" style="display: none">
          <li>⭐️</li>
          <li>💬</li>
        </ul>
      </li>`
      : ''
  )
  .join('');

document.getElementById('list').innerHTML += friend
  .map(
    (el, index) => `<li class=${index + 1}>
      <div class="profile_img">
        <img
          src="${el.icon_url}"
          onerror="this.onerror=null; this.src='../img/profile.svg';"
        />
      </div>
      <div class="detail">
        <p>${el.name}</p>
        ${el.value.length != 0 ? `<p>${el.value}</p>` : ''}
      </div>
      <ul id="bookmark" style="display: none">
        <li>⭐️</li>
        <li>💬</li>
      </ul>
    </li>`
  )
  .join('');

document.getElementById('listLength').innerHTML = friend.length;

function toggle(id) {
  if (id === 'arrowLike') {
    let like = document.getElementById('like');
    let arrow = document.querySelector('#arrowLike');

    if (like.style.display === 'none') {
      like.style.display = 'block';
    } else like.style.display = 'none';

    if (arrow.style.transform === 'rotate(0deg)') {
      arrow.style.transform = 'rotate(180deg)';
    } else arrow.style.transform = 'rotate(0deg)';
  } else {
    let list = document.getElementById('list');
    let arrow = document.querySelector('#arrowList');

    if (list.style.display === 'none') {
      list.style.display = 'block';
    } else list.style.display = 'none';

    if (arrow.style.transform === 'rotate(0deg)') {
      arrow.style.transform = 'rotate(180deg)';
    } else arrow.style.transform = 'rotate(0deg)';
  }
}

const likeTab = document.querySelector('#like');
const listTab = document.querySelector('#list');
const li = document.getElementById('bookmark');

listTab.addEventListener('click', bookmarker);

function bookmarker(e) {
  console.log(e);
  if (li.style.display === 'none') {
    li.style.display = 'flex';
  } else {
    li.style.display = 'none';
  }
}
