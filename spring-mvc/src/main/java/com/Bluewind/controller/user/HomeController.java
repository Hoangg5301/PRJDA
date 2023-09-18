package com.Bluewind.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeControllerOfUser")
public interface HomeController {
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage();
}
