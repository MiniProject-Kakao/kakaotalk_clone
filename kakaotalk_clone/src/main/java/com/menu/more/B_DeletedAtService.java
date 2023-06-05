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
        moreDAO.updateDeletedAt(phone, deletedAt);
        return true; // 탈퇴 성공
    }

    private String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentTime = now.format(formatter);
        return currentTime;
    }
}