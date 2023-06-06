package com.friend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class FriendController {
	@Autowired
	@Qualifier("friendServiceImpl")
	FriendService service;

	@GetMapping("/home")
	public ModelAndView friendList(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		System.out.println(session.getAttribute("my_user_id"));
		if (session.getAttribute("my_user_id") != null) {
			String my_id = session.getAttribute("my_user_id").toString();
			List<FriendResultDTO> friend_list = service.getTotalFriend(my_id);
			UserDTO my_info = service.findUserById(my_id);
			
			mv.addObject("friend_list", friend_list);
			mv.addObject("my_info", my_info);
			
			mv.setViewName("home");
		}

		return mv;
	}
	
	@PostMapping("/addFriend")
	public ModelAndView addFriend(HttpSession session,String name, String phone) {
		ModelAndView mv = new ModelAndView();

		int check = 3;
		if (session.getAttribute("my_user_id") != null) {
			String my_user_id = session.getAttribute("my_user_id").toString();

			check = service.addFreind(name, phone,my_user_id);	
		}
		
		mv.addObject("check",check);
		mv.setViewName("redirect:/home");
		return mv;
	}
	
	@PostMapping("/home")
	public ModelAndView updateFollow(@RequestParam("follow") Boolean follow, @RequestParam("idValue") String idValue) {
		service.updateFollow(follow, idValue);

		return new ModelAndView("redirect:/home");
	}
	
	@GetMapping("/search")
	public ModelAndView searchList(HttpSession session, @RequestParam("word") String word) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("my_user_id") != null) {
			String my_user_id = session.getAttribute("my_user_id").toString();
			List<FriendResultDTO> search_list = service.searchList(my_user_id, word);
			
			System.out.println(word);
			mv.addObject("search_list",search_list);
		}
		
		mv.setViewName("redirect:/home");
		return mv;
	}
	
	
}
