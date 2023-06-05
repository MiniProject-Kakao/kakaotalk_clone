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

/*
const likeTab = document.querySelector('#like');
const listTab = document.querySelector('#list');
const li = document.querySelector('#like #bookmark');
const li2 = document.querySelector('#list #bookmark');

likeTab.addEventListener('click', bookmarker);
listTab.addEventListener('click', bookmarker2);
function bookmarker(e) {
  if (li.style.display === 'none') {
    li.style.display = 'flex';
  } else {
    li.style.display = 'none';
  }
}
function bookmarker2(e) {
  if (li2.style.display === 'none') {
    li2.style.display = 'flex';
  } else {
    li2.style.display = 'none';
  }
}*/
