 function checkemail(){
	 var duplicheck;
        var mail = $('#mail').val(); 
        var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
        if(!getMail.test($("#mail").val())){
        $('#join').attr("disabled",true);
        duplicheck=false;
        $(".dumail").text("이메일 형식을 지켜주세요.");
        $('.dumail').css("color","red"); 
    	}
    	else{
			duplicheck=true;
		}
        $.ajax({
            url:'/duplimailCheck', 
            type:'post', 
            data:{mail:mail},
            success:function(cnt){ 
				if(duplicheck=true){
	                if(cnt == 0){ 
	                    $(".dumail").text("가입 가능한 이메일입니다.");
	                    $('.dumail').css("color","blue"); 
	                    
	                } else { 
	                    $(".dumail").text("가입이 완료된 이메일입니다.");
	                    $('.dumail').css("color","red"); 
	                    $('#join').attr("disabled",true);
	                }
                }
            }
        });
        
        $
        };
 function checkephone(){
	 var duplicheck;
        var phone = $('#phone').val(); 
        var getPhone = RegExp(/^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$/);
        if(!getPhone.test($("#phone").val())){
        $('#join').attr("disabled",true);
        duplicheck=false;
        $(".duphone").text("핸드폰번호를 확인해주세요.");
        $('.duphone').css("color","red"); 
    	}
    	else{
			duplicheck=true;
		}
        
        $.ajax({
            url:'/dupliphonecheck', 
            type:'post', 
            data:{phone:phone},
            success:function(cnt){ 
				if(duplicheck==true){
	                if(cnt == 0){ 
	                    $(".duphone").text("가입 가능한 핸드폰번호입니다.");
	                    $('.duphone').css("color","blue"); 
	                    
	                } else { 
	                    $(".duphone").text("가입이 완료된 핸드폰번호입니다.");
	                    $('.duphone').css("color","red"); 
	                    $('#join').attr("disabled",true);
	                }
                }
            }
        });
        };