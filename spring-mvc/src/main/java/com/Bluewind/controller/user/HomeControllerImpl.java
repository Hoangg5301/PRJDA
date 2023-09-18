package com.Bluewind.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeControllerImpl implements HomeController{

	@Override
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("user/home");
		return mav;
	}
	
}
