document.getElementById('user').innerHTML += `<div><img src=${
  user.icon_url
} /></div>
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
    let like = document.getElementById('like');
    if (like.style.display == 'none') like.style.display = 'block';
    else like.style.display = 'none';

    let arrow = document.querySelector('#arrowLike');
    if (arrow.style.transform == 'rotate(0deg)')
      arrow.style.transform = `rotate(180deg)`;
    else arrow.style.transform = `rotate(0deg)`;
  } else {
    let list = document.getElementById('list');
    if (list.style.display == 'none') list.style.display = 'block';
    else list.style.display = 'none';

    let arrow = document.querySelector('#arrowList');
    if (arrow.style.transform == 'rotate(0deg)')
      arrow.style.transform = `rotate(180deg)`;
    else arrow.style.transform = `rotate(0deg)`;
  }
}
