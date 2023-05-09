document.getElementById('user').innerHTML += `
  <div><img src=${user.icon_url} /></div>
  <div>
    <p>${user.name}</p>
    ${user.value.length != 0 ? `<p>${user.value}</p>` : ''}
  </div>`;

document.getElementById('like').innerHTML += friend
  .map(el =>
    el.like
      ? `<li>
          <div><img src=${el.icon_url} /></div>
          <div>
            <p>${el.name}</p>
            ${el.value.length != 0 ? `<p>${el.value}</p>` : ''}
          </div>
        </li>`
      : ''
  )
  .join('');

document.getElementById('list').innerHTML += friend
  .map(
    el => `<li>
      <div><img src=${el.icon_url} /></div>
      <div>
        <p>${el.name}</p>
        ${el.value.length != 0 ? `<p>${el.value}</p>` : ''}
      </div>
    </li>`
  )
  .join('');

document.getElementById('listLength').innerHTML = friend.length;

function toggle(id) {
  if (id === 'arrowLike') {
    let like_display = document.getElementById('like').style.display;
    let arrow_transform = document.querySelector('#arrowLike').style.transform;

    if (like_display === 'none') {
      like_display = 'block';
    } else like_display = 'none';

    if (arrow_transform === 'rotate(0deg)') {
      arrow_transform = `rotate(180deg)`;
    } else arrow_transform = `rotate(0deg)`;
  } else {
    let list_display = document.getElementById('list').style.display;
    let arrow_transform = document.querySelector('#arrowList').style.transform;

    if (list_display === 'none') {
      list_display = 'block';
    } else list_display = 'none';

    if (arrow_transform === 'rotate(0deg)') {
      arrow_transform = `rotate(180deg)`;
    } else arrow_transform = `rotate(0deg)`;
  }
}
