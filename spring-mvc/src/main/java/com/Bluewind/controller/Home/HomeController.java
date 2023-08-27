package com.Bluewind.controller.Home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public interface HomeController {
	@RequestMapping(value = "/Bluewind", method = RequestMethod.GET)
	public ModelAndView homePage();
}
