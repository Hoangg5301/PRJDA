package com.Bluewind.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "postControllerOfAdmin")
public class PostController {
	@RequestMapping(value = "/home-post-admin", method = RequestMethod.GET)
	public ModelAndView postPage() {
		ModelAndView mav = new ModelAndView("admin/posts/post");
		return mav;
	}
}
