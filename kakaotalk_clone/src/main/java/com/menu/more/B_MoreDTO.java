package com.menu.more;

public class B_MoreDTO {
	//이름,계정,핸드폰번호부분
	    private String name;
	    private String email;
	    private String phone;
    //프로필이름,상태메세지
	    private String username;
	    private String statusMessage;	    
	//탈퇴하기, 예,아니요 버튼
	    //private String 
	    
	//이름,계정,핸드폰부분
	    public String getName() {
	        return name;
	    }
	    
	    public void setName(String name) {
	        this.name = name;
	    }
	    
	    public String getEmail() {
	        return email;
	    }
	    
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    
	    public String getPhone() {
	        return phone;
	    }
	    public void setPhone(String phone) {
	        this.phone = phone;
	    }
	//프로필이름,상태메세지    
	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getStatusMessage() {
	        return statusMessage;
	    }

	    public void setStatusMessage(String statusMessage) {
	        this.statusMessage = statusMessage;
	    }
	}
	

