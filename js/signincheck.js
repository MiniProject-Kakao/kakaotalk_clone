
function check(){

    var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
    var getCheck= RegExp(/^[a-zA-Z0-9]{4,12}$/);


    if(!getMail.test($("#id").val())){
        alert("형식에 맞게 입력해주세요");
        $("#id").val("");
        $("#id").focus();
        return false;
      }

      if(!getCheck.test($("#pw").val())){
        alert("형식에 맞게 입력해주세요");
        $("#pw").val("");
        $("#pw").focus();
        return false;
      }
}






