function numCheck1(){
    var buttonvalue = $("#num-st").val();
    var key ;
    
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
    var mail = $("#mail").val(); //사용자의 이메일 입력값. 
		
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
            dataType :'json',
            async : false,
            success : function(data){
				key=JSON.parse(data);
				alert(key);
			}

        });
    $("#result").text("인증번호 남은시간 : ");
    $.time(180);
        alert("인증번호가 전송되었습니다.") 
        isCertification=true; //추후 인증 여부를 알기위한 값
    }
    $("#num-st").val("인증번호 확인"); 
    }
    
    
    if(buttonvalue=="인증번호 확인"){
		if($("#reuslt").val() == key){
			$("#result-1").text("이메일 인증을 완료했습니다.");
			isCertification=true;
		}
		else{
			$("#result-1").text("이메일 인증번호를 다시 확인해주세요.");
			isCertification=false;
			
		}
		
	}
    
    


}