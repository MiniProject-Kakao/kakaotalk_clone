function DateView(updated_at) {
  let date = new Date(updated_at);
  let now = new Date();
  let result;
  if (date.getFullYear() - now.getFullYear() < 0) {
    result =
      date.getFullYear() +
      '.' +
      ('00' + (date.getMonth() + 1).toString()).slice(-2) +
      '.' +
      ('00' + date.getDate().toString()).slice(-2);
  } else {
    if (
      now.getMonth() - date.getMonth() == 0 &&
      now.getDay() - date.getDay() == 0
    ) {
      let an;
      let hour = date.getHours();
      if (date.getHours() < 12) {
        an = '오전';
      } else {
        an = '오후';
        hour -= 12;
      }
      result = an + ' ' + hour + ':' + date.getMinutes();
    } else {
      result = date.getMonth() + 1 + '월 ' + date.getDate() + '일';
    }
  }
  return result;
}

document.getElementById('list').innerHTML += chatroom
  .map(el =>
    el.lastchat.length == 0
      ? `<li class='croomList'>
        <div><img src=${el.cr_icon_url} /></div>
        <div>
          <p>${el.cr_name}</p>
        </div>
      </li>`
      : `<li class='croomList'>
        <div><img src=${el.cr_icon_url} /></div>
        <div>
          <p>${el.cr_name}</p>
          <p>${el.lastchat}</p>
        </div>
        <div>
            <p>${DateView(el.updated_at)}</p>
        </div>
      </li>`
  )
  .join('');

let crooms = document.querySelectorAll('.croomList');
crooms.forEach(target => target.addEventListener('click', goChatRoom));

function goChatRoom() {
  location.href = '../html/chat.html';
}
