document.getElementById('user').innerHTML +=
  user.value.length == 0
    ? `<div>
  <img src=${user.icon_url}>
  </div>
  <div>
    <p>${user.name}</p>
  </div>`
    : `<div>
    <img src=${user.icon_url}>
  </div>
  <div>
    <p>${user.name}</p>
    <p>${user.value}</p>
  </div>`;

document.getElementById('like').innerHTML += friend
  .map(el =>
    el.like
      ? el.value.length == 0
        ? `<li>
      <div><img src=${el.icon_url} /></div>
      <div>
        <p>${el.name}</p>
      </div>
      </li>`
        : `<li>
      <div><img src=${el.icon_url} /></div>
      <div>
        <p>${el.name}</p>
        <p>${el.value}</p>
      </div>
      </li>`
      : ''
  )
  .join('');

document.getElementById('list').innerHTML += friend
  .map(el =>
    el.value.length == 0
      ? `<li>
      <div><img src=${el.icon_url} /></div>
      <div>
        <p>${el.name}</p>
      </div>
      </li>`
      : `<li>
      <div><img src=${el.icon_url} /></div>
      <div>
        <p>${el.name}</p>
        <p>${el.value}</p>
      </div>
      </li>`
  )
  .join('');

document.getElementById('listLength').innerHTML = friend.length;

function toggle(id) {
  let like = document.getElementById('like');
  let list = document.getElementById('list');
  if (id == 'arrowLike') {
    if (like.style.display == 'none') {
      like.style.display = 'block';
    } else {
      like.style.display = 'none';
    }
  } else {
    if (list.style.display == 'none') {
      list.style.display = 'block';
    } else {
      list.style.display = 'none';
    }
  }

  if (id == 'arrowLike') {
    let arrow = document.querySelector('#arrowLike');
    if (arrow.style.transform == 'rotate(0deg)') {
      arrow.style.transform = `rotate(180deg)`;
    } else {
      arrow.style.transform = `rotate(0deg)`;
    }
  } else {
    let arrow = document.querySelector('#arrowList');
    if (arrow.style.transform == 'rotate(0deg)') {
      arrow.style.transform = `rotate(180deg)`;
    } else {
      arrow.style.transform = `rotate(0deg)`;
    }
  }
}
