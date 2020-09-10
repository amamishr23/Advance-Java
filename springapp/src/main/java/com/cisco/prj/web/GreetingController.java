package com.cisco.prj.web;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {

	@RequestMapping("greet.do")
	public ModelAndView getHomePage() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "Banuprakash");
		mav.addObject("today", new Date());
		mav.setViewName("home.jsp");
		return mav;
	}
}
