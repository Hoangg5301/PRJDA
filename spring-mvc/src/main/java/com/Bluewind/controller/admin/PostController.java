package com.Bluewind.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Bluewind.dto.admin.PostDTO;
import com.Bluewind.service.IPostService;
import com.Bluewind.util.MessageUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@Controller(value = "postControllerOfAdmin")
public class PostController {
	
	@Autowired
	private IPostService postService;

	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/home-post-admin", method = RequestMethod.GET)
	public ModelAndView postPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/posts/post");
		PostDTO postDTO = postService.findAll();
		if(request.getParameter("message") != null) {
			Map<String, String> mapMessage = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", mapMessage.get("message"));
			mav.addObject("alert", mapMessage.get("alert"));
		}

		mav.addObject("model",postDTO);
		return mav;
	}
	
	@RequestMapping(value = "/home-postupdate-admin", method = RequestMethod.GET)
	public ModelAndView getUpdate(@RequestParam(value ="id", required = false) Integer id) {
		
		ModelAndView mav = new ModelAndView("admin/posts/postEdit");
		PostDTO postDTO = new PostDTO();
		if(id == null) {
			mav.addObject("model", postDTO);
			return mav;
		}else{
			postDTO = postService.findById(id);
			mav.addObject("model", postDTO);
			return mav;
		}
	}
}
