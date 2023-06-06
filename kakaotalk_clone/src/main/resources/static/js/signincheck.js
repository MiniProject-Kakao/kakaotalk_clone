
function check(){
    
    var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
    var getCheck = RegExp(/^[a-zA-Z0-9]{4,12}$/);
    var getPhone = RegExp(/^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$/);
    
    if(getMail.test($("#id").val()) || getPhone.test($("#id").val())){
    
    }
    else {
    alert("이메일 및 번호가 맞는지 확인해주세요.");
    $("#id").val("");
    $("#id").focus();
    return false;
    }
    
    if(!getCheck.test($("#pw").val())){
        alert("비밀번호를 확인해주세요");
        $("#pw").val("");
        $("#pw").focus();
        return false;
    }
	
	
}






