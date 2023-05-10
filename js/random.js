function numCheck1(){
    
    var randomnum='';
    for (var i=0; i<5;i++){
        randomnum += Math.floor(Math.random()*10)
    }
    
    $("#result").text("인증번호는 "+randomnum+" 입니다.");

}