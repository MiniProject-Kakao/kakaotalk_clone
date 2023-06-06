const addUserIcon = document.getElementById('addUser_icon');
const form = document.getElementById('addUser_form');
const inputName = document.getElementById('inputName');
const inputPhone = document.getElementById('inputPhone');
const button = document.getElementById('addButton');

addUserIcon.addEventListener('click', modal);

function modal() {
  if (form.style.display === 'none') {
    form.style.display = 'flex';
    inputName.focus();
  } else {
    inputName.value = '';
    inputPhone.value = '';
    form.style.display = 'none';
    button.classList.remove('active');
  }
}

inputName.addEventListener('keyup', activeButton);
inputPhone.addEventListener('keyup', activeButton);

function activeButton() {
  let nameValue = inputName.value;
  let phoneValue = inputPhone.value;

  if (nameValue.length > 0 && phoneValue.length >= 10) {
    button.classList.add('active');
  } else {
    button.classList.remove('active');
  }
}
