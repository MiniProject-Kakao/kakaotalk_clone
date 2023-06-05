package com.chat.chatroom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChatController {
	
	@Autowired
	@Qualifier("chatServiceImpl")
	ChatService service;
	
	@RequestMapping("/chat")
	public ModelAndView chat(@RequestParam String chat_list_id) {
		List<ChatDTO> list = service.getMonthChat(chat_list_id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chat");
		mv.addObject("chatlog", list);
		return mv;
	}
}
