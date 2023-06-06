package com.chat.chatroom.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.chat.chatlist.ChatListDTO;
import com.chat.chatlist.ChatListService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ChatController {
	
	@Autowired
	@Qualifier("chatServiceImpl")
	ChatService service;
	
	@Autowired
	@Qualifier("chatListServiceImpl")
	ChatListService CLservice;
	
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
			
			ChatListDTO CLdto = new ChatListDTO();
			CLdto.setChat_list_id(dto.getChat_list_id());
			CLdto.setLast_content("사진");
			int updateCount = CLservice.updateLastChat(CLdto);
		}
		ModelAndView mv = new ModelAndView();
		List<ChatDTO> list = service.getMonthChat(dto.getChat_list_id());
		mv.setViewName("chat");
		mv.addObject("chatlog", list);
		return mv;
	}
	
	@PostMapping("/createchatroomifnull")
	@ResponseBody
	public String createchatroomifnull(@RequestParam(value="friendId", required=false) String friendId, HttpSession session) {
		HashMap<String, String> map = new HashMap<>();
		System.out.println("first : " + friendId + " ~ " + (String)session.getAttribute("my_user_id"));
		map.put("my_user_id", (String)session.getAttribute("my_user_id"));
		map.put("friendId", friendId);
		String str = UUID.randomUUID().toString();
		map.put("last_content", UUID.randomUUID().toString());
		int checkresult = service.checkChatList(map);
		if (checkresult == 0) {
			System.out.println("채팅방 있는지 조회결과(숫자) : " + checkresult);
			int setchatlistresult = CLservice.setChatList(map);
			System.out.println("채팅방 생성(chat_list 테이블) 결과 1(성공) or 0(실패): " + setchatlistresult);
			String chat_list_id = CLservice.getSpecificChatRoom2(map);
			map.put("chat_list_id", chat_list_id);
			int firstinsertuserjoin = CLservice.firstinsertuserjoin(map);
			System.out.println("채팅방 생성중간과정1(user_join 테이블) 결과 1(성공) or 0(실패): " + firstinsertuserjoin);
			int secondinsertuserjoin = CLservice.secondinsertuserjoin(map);
			System.out.println("채팅방 생성중간과정2(user_join 테이블) 결과 1(성공) or 0(실패): " + secondinsertuserjoin);
			int defaultchatinsert = service.insertChatDefault(map);
			System.out.println("채팅방 생성후 기본멘트 채팅방을 열였습니다. 데이터 입력 결과 1(성공) or 0(실패): " + defaultchatinsert);
			int updateLastChatDefault = CLservice.updateLastChatDefault(chat_list_id);
			System.out.println("최종단계 chat_list 테이블(last_content 기본멘트로 변경) 데이터 입력 결과 1(성공) or 0(실패): " + updateLastChatDefault);
			return chat_list_id;
		} else {
			System.out.println("이미 채팅방이 있음");
			String chat_list_id = CLservice.getSpecificChatRoom(map);
			System.out.println("이미 있는 채팅방 조회 : " + chat_list_id);
			return chat_list_id;
		}
		
	}
	
	
}
