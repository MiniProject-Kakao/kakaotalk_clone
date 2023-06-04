package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@Autowired
	Y_MemberService ms;
	
	
	@RequestMapping("/")
	public String start() {
		return "signin";
	}
	
	@RequestMapping("/signin")
	public ModelAndView signin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("signin");
		
		return mv;
	}
	@RequestMapping("/signup")
	public ModelAndView signup() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("signup");
		return mv;
	}
	
	@PostMapping("/signup")
	public String signup(Y_MemberDTO Y_MemberDTO) {
		if(ms.insertMember(Y_MemberDTO)>0) {
			return "signin";
		}
		else return "signup";
	}
	
	
	
	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		
		return mv;
	}
	
	@RequestMapping("/more")
	public ModelAndView more() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("more");
		
		return mv;
	}
}
