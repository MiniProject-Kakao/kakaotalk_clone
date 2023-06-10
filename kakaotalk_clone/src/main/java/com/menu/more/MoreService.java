package com.menu.more;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class MoreService {
    @Autowired
    private MoreDAO moreDao;

    public boolean updateDeletedAt(String userId) {
        String deletedAt = getCurrentTime();
        int rowsAffected = moreDao.updateDeletedAt(userId, deletedAt);
        System.out.println(rowsAffected);
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
        MoreDTO bMoreDTO = new MoreDTO();
        bMoreDTO.setPhone(phone);
        bMoreDTO.setUsername(updatedUsername);
        bMoreDTO.setStatusMessage(updatedStatusMessage);
//내용추가
        int rowsAffected = moreDao.updateUserStatus(bMoreDTO);
        if (rowsAffected > 0) {
            return true;  // 수정 성공
        } else {
            return false; // 수정 실패
        }
    }

	public MoreDTO more(String phone) {
		MoreDTO moreDto = new MoreDTO();
		
		moreDto = moreDao.selectByPhone(phone);
		
		return moreDto;
	}

	public MoreDTO getMore(String sessionId) {

		return moreDao.selectUserById(sessionId);
		
	}
}