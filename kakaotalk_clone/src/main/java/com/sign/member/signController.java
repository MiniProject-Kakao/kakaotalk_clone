package com.sign.member;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
@Controller
public class signController {
	
	@Autowired
	@Qualifier("memberservice")
	MemberService ms;
	
	@RequestMapping("/signin")
	public ModelAndView signin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("signin");
		
		return mv;
	}
	
	
	@GetMapping("/signup")
	public String signup1(Model model) {
			model.addAttribute("title", "회원가입");
			
			return "signup";
			
	}
	
	@PostMapping("/signup")
	public String signup(MemberDTO memberDTO) {
		if(ms.insertMember(memberDTO)>0) {
			return "signin";
		}
		else return "signup";
	}
	
	
	@PostMapping("/Login")
	public String loginprocess(String id, String password,HttpSession session) {
		MemberDTO dto = ms.LoginMember(id);
		if(dto != null) {
			if(dto.getPassword().equals(password)) {
				session.setAttribute("my_user_id", dto.getUser_id());
				return "redirect:/home" ;
			}
	}
		return "signin";

}
}

