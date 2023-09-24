package com.Bluewind.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "productControllerOfAdmin")
public class ProductController {
	@RequestMapping(value = "/home-product-admin", method = RequestMethod.GET)
	public ModelAndView productPage() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
}
