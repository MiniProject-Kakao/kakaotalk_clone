package com.menu.more;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class B_DeletedAtService {
    @Autowired
    private B_MoreDAO moreDAO;

    public boolean updateDeletedAt(String phone) {
        String deletedAt = getCurrentTime();
        int rowsAffected = moreDAO.updateDeletedAt(phone, deletedAt);
        if (rowsAffected > 0) {
            return true;  // 탈퇴 성공
        } else {
            return false; // 탈퇴 실패
        }
    }

    private String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentTime = now.format(formatter);
        return currentTime;
    }
    public boolean updateUserStatus(String phone, String updatedUsername, String updatedStatusMessage) {
        B_MoreDTO bMoreDTO = new B_MoreDTO();
        bMoreDTO.setPhone(phone);
        bMoreDTO.setUsername(updatedUsername);
        bMoreDTO.setStatusMessage(updatedStatusMessage);
//내용추가
        int rowsAffected = moreDAO.updateUserStatus(bMoreDTO);
        if (rowsAffected > 0) {
            return true;  // 수정 성공
        } else {
            return false; // 수정 실패
        }
    }
}