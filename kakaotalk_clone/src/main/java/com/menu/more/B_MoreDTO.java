package com.menu.more;

public class B_MoreDTO {
    // 이름, 계정, 핸드폰번호 부분
    private String name;
    private String email;
    private String phone;

    // 프로필 이름, 상태 메세지
    private String username;
    private String statusMessage;

    
    private String contact;
    private String profileImage;

    // 이름, 계정, 핸드폰 부분
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

    // 프로필 이름, 상태 메세지
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

    //내용추가
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    
    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}