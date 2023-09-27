package com.Bluewind.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "accountControllerOfAdmin")
public class AccountController {
	@RequestMapping(value = "/home-account-admin", method = RequestMethod.GET)
	public ModelAndView accountPage() {
		ModelAndView mav = new ModelAndView("admin/accounts/account");
		return mav;
	}
}
