package com.Bluewind.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "orderControllerOfAdmin")
public class OrderController {
	@RequestMapping(value = "/home-order-admin", method = RequestMethod.GET)
	public ModelAndView orderPage() {
		ModelAndView mav = new ModelAndView("admin/orders/order");
		return mav;
	}
}
