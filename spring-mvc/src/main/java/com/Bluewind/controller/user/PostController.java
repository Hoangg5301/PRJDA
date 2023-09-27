package com.Bluewind.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "postControllerUser")
public class PostController {
	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public ModelAndView postPage() {
		ModelAndView mav = new ModelAndView("user/posts/post");
		return mav;
	}
}