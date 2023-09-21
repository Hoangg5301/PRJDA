package com.Bluewind.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "brandControllerOfAdmin")
public class BrandController {
	@RequestMapping(value = "/home-brand-admin", method = RequestMethod.GET)
	public ModelAndView categoryPage() {
		ModelAndView mav = new ModelAndView("admin/brand");
		return mav;
	}
}
