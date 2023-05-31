function numCheck1(){
    
    var randomnum='';
    for (var i=0; i<5;i++){
        randomnum += Math.floor(Math.random()*10)
    }
    
    $("#result").text("인증번호는 "+randomnum+" 입니다.");


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

    $.time(180);


}