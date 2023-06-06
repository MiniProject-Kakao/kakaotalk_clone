function toggle(id) {
  if (id === 'arrowLike') {
    let like = document.getElementById('like');
    let arrow = document.querySelector('#arrow_like');

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