package com.friend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class FriendController {
	@Autowired
	@Qualifier("friendServiceImpl")
	FriendService service;

	@RequestMapping("/home")
	public ModelAndView myuserid(HttpSession session) {
//		session.setAttribute("my_user_id","9b012248-ff87-11ed-9979-b2f8c3e84292");

		ModelAndView mv = new ModelAndView();

		if (session.getAttribute("my_user_id") != null) {
			String my_id = session.getAttribute("my_user_id").toString();
			List<FriendDTO> friend_list = service.getTotalFriend(my_id);

			System.out.println(friend_list.toString());
			
			mv.addObject("friend_list", friend_list);
				
			mv.setViewName("home");
		}

		return mv;
	}
}
