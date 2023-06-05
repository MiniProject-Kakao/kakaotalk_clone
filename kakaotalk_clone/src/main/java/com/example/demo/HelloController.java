package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sign.member.MemberDTO;
import com.sign.member.MemberService;

@Controller
public class HelloController {
	
	
	@RequestMapping("/")
	public String start() {
		return "signin";
	}
	
	
	@RequestMapping("/more")
	public ModelAndView more() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("more");
		
		return mv;
	}
}
