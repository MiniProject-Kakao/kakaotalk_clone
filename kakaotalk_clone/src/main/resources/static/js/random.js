var test;
function numCheck1(){
    var buttonvalue = $("#num-st").val();
    
    
    if(buttonvalue=="인증번호 발송"){
		var randomnum='';
    for (var i=0; i<5;i++){
        randomnum += Math.floor(Math.random()*10)
    }


    let countTime = 0;
    let intervalCall;

    $.time = function(time){
        countTime = time;
        intervalCall = setInterval(alertFunc, 1000);
    }

    $.closeTime = function(){
        clearInterval(intervalCall);
   }
   
   
    function alertFunc() {
        let min = Math.floor(countTime/60);
        let sec = countTime - (60 * min);
        if(sec > 9){
            $('.time').text(min + ':' + sec + '');
        }else {
            $('.time').text(min + ':0' + sec + '');
        }
        if(countTime <= 0){
            clearInterval(intervalCall);
        }
        countTime--;
    };
    
    var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
    var mail = $("#mail").val(); 
		
    if(!getMail.test($("#mail").val())){
        alert("이메일형식에 맞게 입력해주세요");
        $("#mail").val("");
        $("#mail").focus();
        return false;
    }
        
    else {
        $.ajax({
            type : 'post',
            url : '/CheckMail',
            data : {
                mail:mail
                },
            success : function(data){
				test = data;
				$('#test').text(test);
				}
        });
    $("#result").text("인증번호 남은시간 : ");
    $.time(180);
        alert("인증번호가 전송되었습니다.")
    }
    $("#num-st").css("display","none");
    $("#num-st1").css("display","inline-block"); 
    }
    

}

function emailnum(){
	if($("#num").val() == test){
				$("#result-1").text("이메일 인증을 완료했습니다.");
					}
					else{
				$("#result-1").text("이메일 인증번호를 다시 확인해주세요.");
				$('#join').attr("disabled",true);
				}
}