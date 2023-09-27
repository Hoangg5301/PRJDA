package com.Bluewind.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "promotionControllerOfAdmin")
public class PromotionController {
	@RequestMapping(value = "/home-promotion-admin", method = RequestMethod.GET)
	public ModelAndView promotionPage() {
		ModelAndView mav = new ModelAndView("admin/promotions/promotion");
		return mav;
	}
}
