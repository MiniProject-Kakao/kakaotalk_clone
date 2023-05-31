package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
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
	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		
		return mv;
	}
	@RequestMapping("/chat")
	public ModelAndView chat() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chat");
		
		return mv;
	}
	@RequestMapping("/chatlist")
	public ModelAndView chatlist() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chatList");
		
		return mv;
	}
	@RequestMapping("/more")
	public ModelAndView more() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("more");
		
		return mv;
	}
}
