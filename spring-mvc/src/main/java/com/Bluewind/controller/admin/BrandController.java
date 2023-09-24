package com.Bluewind.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Bluewind.dto.admin.BrandDTO;
import com.Bluewind.service.IBrandService;
import com.Bluewind.util.MessageUtil;

@Controller(value = "brandControllerOfAdmin")
public class BrandController {
	
	@Autowired
	private MessageUtil messageUtil;
	@Autowired
	private IBrandService brandService;
	
	@RequestMapping(value = "/home-brand-admin", method = RequestMethod.GET)
	public ModelAndView displayList(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView("admin/brands/brand");
		BrandDTO brandDTO = new BrandDTO();
		brandDTO.setListResult(brandService.findAll());
		
		if(request.getParameter("message") != null) {
			Map<String, String> mapMessage = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", mapMessage.get("message"));
			mav.addObject("alert", mapMessage.get("alert"));
		}
		mav.addObject("model",brandDTO);
		return mav;
	}
	
	@RequestMapping(value = "/home-brandupdate-admin", method = RequestMethod.GET)
	public ModelAndView getUpdate(@RequestParam(value ="id", required = false) Integer id) {
		
		ModelAndView mav = new ModelAndView("admin/brands/brandEdit");
		BrandDTO brandDTO = new BrandDTO();
		if(id == null) {
			mav.addObject("model", brandDTO);
			return mav;
		}else{
			brandDTO = brandService.findById(id);
			mav.addObject("model", brandDTO);
			return mav;
		}
	}
}
