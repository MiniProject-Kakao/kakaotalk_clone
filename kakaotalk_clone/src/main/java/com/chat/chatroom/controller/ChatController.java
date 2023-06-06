package com.chat.chatroom.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	
	@PostMapping("/imgupload")
	public ModelAndView uploadresult(UploadDTO dto) throws IllegalStateException, IOException{
		String savePath = "c:/kdt/upload/";
		MultipartFile file1 = dto.getFile1();
		String newFilename1 = null;
		if (!file1.isEmpty()) {
			String originalname1 = file1.getOriginalFilename();
			String beforeext1 = originalname1.substring(0, originalname1.indexOf("."));
			String ext1 = originalname1.substring(originalname1.indexOf("."));
			newFilename1 = beforeext1 + "(" + UUID.randomUUID().toString() + ")" + ext1;
			file1.transferTo(new File(savePath + newFilename1));
			
			ChatDTO dtoc = new ChatDTO();
			dtoc.setChat_list_id(dto.getChat_list_id());
			dtoc.setUser_id(dto.getUser_id());
			dtoc.setContent("/upload/" + newFilename1);
			dtoc.setType(dto.getType());
			int insertCount = service.insertChat(dtoc);
		}
		ModelAndView mv = new ModelAndView();
		List<ChatDTO> list = service.getMonthChat(dto.getChat_list_id());
		mv.setViewName("chat");
		mv.addObject("chatlog", list);
		return mv;
	}
	
}
