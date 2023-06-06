$("#name").on('input', checkInput);
$("#phone").on('input', checkInput);
$("#num").on('input', checkInput);
$("#mail").on('input', checkInput);
$("#pw").on('input', checkInput);
$("#pw2").on('input', checkInput);




function checkInput() {
  var nameCheck = $("#name").val();   
  var phoneCheck =$("#phone").val();
  var numCheck =$("#num").val();
  var mailCheck = $("#mail").val();
  var passwordCheck = $("#pw").val();   
  var passwordCheck2 = $("#pw2").val();
  var join = $('.join');

    if ((nameCheck==='' || phoneCheck==='' )||((mailCheck === '' || passwordCheck === '' )||(passwordCheck2 === ''|| numCheck === ''))) {
    join.removeClass('on');
    join.attr("disabled", true);
  } else {
    join.addClass('on');
    join.attr("disabled", false);
  }
}

