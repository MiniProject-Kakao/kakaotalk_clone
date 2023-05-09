const plusUserIcon = document.getElementById('plusUser_icon');
const form = document.getElementById('plusUser_form');
const inputName = document.getElementById('inputName');
const inputPhone = document.getElementById('inputPhone');
const button = document.getElementById('addButton');

plusUserIcon.addEventListener('click', modal);

function modal() {
  if (form.style.display === 'none') {
    form.style.display = 'flex';
    inputName.focus();
  } else {
    form.style.display = 'none';
    inputName.value = '';
    inputPhone.value = '';
    button.disabled = false;
    button.style.backgroundColor = '#F2F2F2';
  }
}

inputName.addEventListener('keyup', activeButton);
inputPhone.addEventListener('keyup', activeButton);

function activeButton() {
  let nameValue = inputName.value;
  let phoneValue = inputPhone.value;

  if (nameValue.length > 0 && phoneValue.length >= 10) {
    button.disabled = true;
    button.style.cursor = 'pointer';
    button.style.color = '#000';
    button.style.backgroundColor = '#FAE64D';
  } else {
    button.disabled = false;
    button.style.backgroundColor = '#F2F2F2';
  }
}
