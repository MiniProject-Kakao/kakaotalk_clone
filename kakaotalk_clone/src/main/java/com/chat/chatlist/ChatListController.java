package com.chat.chatlist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class ChatListController {
	
	@Autowired
	@Qualifier("chatListServiceImpl")
	ChatListService service;
	
	
	@RequestMapping("/chatlist")
	public ModelAndView chatlist(HttpSession session) {
		List<ChatListDTO> chatlist = service.getAllChatList((String) session.getAttribute("my_user_id"));
		System.out.println(session.getAttribute("my_user_id"));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chatList");
		mv.addObject("chatlist", chatlist);
		return mv;
	}
	

}
