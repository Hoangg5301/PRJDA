package com.Bluewind.controller.admin;

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

@Controller(value = "productTypeControllerOfAdmin")
public class ProductTypeController {
	@Autowired
	private MessageUtil messageUtil;
	@Autowired
	private IBrandService brandService;
	
	@RequestMapping(value = "/home-producttype-admin", method = RequestMethod.GET)
	public ModelAndView displayList(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView("admin/productTypes/productType");

		return mav;
	}
	
	@RequestMapping(value = "/home-producttypeupdate-admin", method = RequestMethod.GET)
	public ModelAndView getUpdate(@RequestParam(value ="id", required = false) Integer id) {
		
		ModelAndView mav = new ModelAndView("");
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