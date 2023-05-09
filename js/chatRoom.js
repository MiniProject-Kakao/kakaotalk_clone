/* dummy data */
const interlocutor = {
  il_name: 'user name',
  il_icon_url:
    'https://t1.daumcdn.net/friends/prod/editor/dc8b3d02-a15a-4afa-a88b-989cf2a50476.jpg'
};

const chatlog = [
  {
    chatter_name: 'user name',
    chatter_icon_url:
      "'https://image.utoimage.com/preview/cp872722/2022/12/202212008462_206.jpg'",
    chatted_at: '2023-05-08 10:42:19.324003',
    chat_data: '안녕하세요.',
    isLast: false
  },
  {
    chatter_name: 'user name',
    chatter_icon_url:
      "'https://image.utoimage.com/preview/cp872722/2022/12/202212008462_206.jpg'",
    chatted_at: '2023-05-08 10:44:19.324003',
    chat_data:
      '[3시간 후] 마우리치오 카텔란전시회 [3시간 후] 마우리치오 카텔란전시회 [3시간 후] 마우리치오 카텔란전시회 [3시간 후] 마우리치오 카텔란전시회',
    isLast: false
  },
  {
    chatter_name: 'user name2',
    chatter_icon_url:
      "'https://t1.daumcdn.net/friends/prod/editor/dc8b3d02-a15a-4afa-a88b-989cf2a50476.jpg'",
    chatted_at: '2023-05-08 10:55:19.324003',
    chat_data: '안녕하세요!',
    isLast: false
  },
  {
    chatter_name: 'user name2',
    chatter_icon_url:
      "'https://t1.daumcdn.net/friends/prod/editor/dc8b3d02-a15a-4afa-a88b-989cf2a50476.jpg'",
    chatted_at: '2023-05-08 10:57:19.324003',
    chat_data: '[3시간 후] 마우리치오 카텔란전시회',
    isLast: false
  },
  {
    chatter_name: 'me',
    chatter_icon_url:
      "'https://t1.daumcdn.net/friends/prod/editor/dc8b3d02-a15a-4afa-a88b-989cf2a50476.jpg'",
    chatted_at: '2023-05-08 11:01:19.324003',
    chat_data: '반갑습니다!',
    isLast: false
  },
  {
    chatter_name: 'me',
    chatter_icon_url:
      "'https://t1.daumcdn.net/friends/prod/editor/dc8b3d02-a15a-4afa-a88b-989cf2a50476.jpg'",
    chatted_at: '2023-05-08 11:03:19.324003',
    chat_data: '반갑습니다!',
    isLast: false
  },
  {
    chatter_name: 'me',
    chatter_icon_url:
      "'https://t1.daumcdn.net/friends/prod/editor/dc8b3d02-a15a-4afa-a88b-989cf2a50476.jpg'",
    chatted_at: '2023-05-08 11:04:19.324003',
    chat_data: '반갑습니다!',
    isLast: false
  },
  {
    chatter_name: 'me',
    chatter_icon_url:
      "'https://t1.daumcdn.net/friends/prod/editor/dc8b3d02-a15a-4afa-a88b-989cf2a50476.jpg'",
    chatted_at: '2023-05-08 11:05:19.324003',
    chat_data: '반갑습니다!',
    isLast: false
  },
  {
    chatter_name: 'me',
    chatter_icon_url:
      "'https://t1.daumcdn.net/friends/prod/editor/dc8b3d02-a15a-4afa-a88b-989cf2a50476.jpg'",
    chatted_at: '2023-05-08 11:06:19.324003',
    chat_data: '반갑습니다!',
    isLast: true
  }
];

document.getElementById('il').innerHTML += `<li>
    <div><img src=${interlocutor.il_icon_url} /></div>
    <div>
        <p>${interlocutor.il_name}</p>
    </div>
</li>`;

function loadChat(chatlog) {}

let temp_name = '';

document.getElementById('chat').innerHTML += chatlog
  .map(function (el) {
    let result = `<li>
            <div>
                <img src=${el.chatter_icon_url}/>
            </div>
            <div><p>${el.chatter_name}</p>
            <div>
                <p>${el.chat_data}</p>
            </div>`;
    if (temp_name == '') {
      temp_name = el.chatter_name;
      if (el.chatter_name != 'me') {
        return result;
      } else if (el.chatter_name == 'me') {
        return `<li class=${'chatStyleMe'}>
        <div>
          <div>
            <p>${el.chat_data}</p>
          </div>`;
      }
    } else if (temp_name == el.chatter_name) {
      if (!el.isLast && el.chatter_name != 'me') {
        return `<div><p>${el.chat_data}</p></div>`;
      } else if (!el.isLast && el.chatter_name == 'me') {
        return `<div><p>${el.chat_data}</p></div>`;
      } else if (el.isLast && el.chatter_name != 'me') {
        return `<div><p>${el.chat_data}</p></div></div></li>`;
      } else if (el.isLast && el.chatter_name == 'me') {
        return `<div><p>${el.chat_data}</p></div></div></li>`;
      }
    } else if (temp_name != el.chatter_name && el.chatter_name != 'me') {
      temp_name = el.chatter_name;
      if (!el.isLast) {
        return `</div></li>` + result;
      } else {
        return (
          `</div></li>` +
          result +
          `<div><p>${el.chat_data}</p></div></div></li>`
        );
      }
    } else if (temp_name != el.chatter_name && el.chatter_name == 'me') {
      temp_name = el.chatter_name;
      if (!el.isLast) {
        return `</div></li>
        <li class=${'chatStyleMe'}>
        <div>
          <div>
            <p>${el.chat_data}</p>
          </div>`;
      } else {
        return `</div></li><div><p>${el.chat_data}</p></div></div></li>`;
      }
    }
  })
  .join('');
