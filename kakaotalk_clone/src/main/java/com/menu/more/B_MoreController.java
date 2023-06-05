package com.menu.more;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class B_MoreController {

	@Autowired
	B_DeletedAtService deletedAtService;

	@RequestMapping("/more")
	public ModelAndView more() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("more");

		return mv;
	}

	@RequestMapping("/more/withdrawal")
	public @ResponseBody String withdrawal(@RequestParam("phone") String phone) {
		deletedAtService.updateDeletedAt(phone);
		return "success";
	}

}