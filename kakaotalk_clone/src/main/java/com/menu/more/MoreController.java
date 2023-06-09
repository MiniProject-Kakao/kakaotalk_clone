package com.menu.more;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/more")
public class MoreController {

	@Autowired
	private MoreService moreService;

	@Autowired
	private MoreDAO moreDAO;
	
	
	@RequestMapping(value = "")
	public ModelAndView more(HttpSession session) {
		String sessionId = (String) session.getAttribute("my_user_id");
		MoreDTO dto = moreService.getMore(sessionId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("more");
		mv.addObject("more", dto);
		return mv;
	}
	

	@RequestMapping("/updateProfile")
	public ModelAndView updateProfile(
			@RequestParam("phone") String phone,
			@RequestParam("updatedUsername") String updatedUsername,
			@RequestParam("updatedStatusMessage") String updatedStatusMessage
	) {
		// 사용자 이름과 상태 메시지가 비어있지 않은지 확인
		if (updatedUsername == null || updatedUsername.trim().isEmpty()) {
			throw new IllegalArgumentException("사용자 이름을 입력하세요.");
		}

		if (updatedStatusMessage == null || updatedStatusMessage.trim().isEmpty()) {
			throw new IllegalArgumentException("상태 메시지를 입력하세요.");
		}

		MoreDTO bMoreDTO = moreDAO.selectByPhone(phone); // 사용자 조회
		if (bMoreDTO == null) {
			// 사용자가 없을 경우의 처리 로직
			throw new IllegalArgumentException("해당 번호를 가진 사용자가 존재하지 않습니다.");
		}

		// 조회된 사용자 정보의 username과 statusMessage 업데이트
		bMoreDTO.setUsername(updatedUsername);
		bMoreDTO.setStatusMessage(updatedStatusMessage);

		// DB에 업데이트
		int affectedRows = moreDAO.updateUserStatus(bMoreDTO);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/signin");
		return mv;
	}
	
	@RequestMapping("/updateDeletedAt")
	public ModelAndView updateDeletedAt(HttpSession session, @RequestParam String phone) {
		System.out.println(phone);
		String sessionId = (String) session.getAttribute("my_user_id");
		ModelAndView mv = new ModelAndView();
		
		if (moreService.updateDeletedAt(sessionId)) {
			mv.setViewName("redirect:/");
		}else {
			mv.setViewName("redirect:/more");
		}
		

		
		
		return mv;
	}
	
}