package com.Bluewind.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Bluewind.dto.admin.ProductTypeDTO;
import com.Bluewind.service.IProductTypeService;
import com.Bluewind.util.MessageUtil;

@Controller(value = "productTypeControllerOfAdmin")
public class ProductTypeController {
	@Autowired
	private MessageUtil messageUtil;
	@Autowired
	private IProductTypeService productTypeService;
	
	@RequestMapping(value = "/home-producttype-admin", method = RequestMethod.GET)
	public ModelAndView displayList(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView("admin/productTypes/productType");
		ProductTypeDTO productTypeDTO = new ProductTypeDTO();
		productTypeDTO.setListResult(productTypeService.findAll());
		
		if(request.getParameter("message") != null) {
			Map<String, String> mapMessage = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", mapMessage.get("message"));
			mav.addObject("alert", mapMessage.get("alert"));
		}
		mav.addObject("model",productTypeDTO);
		

		return mav;
	}
	
	@RequestMapping(value = "/home-producttypeupdate-admin", method = RequestMethod.GET)
	public ModelAndView getUpdate(@RequestParam(value ="id", required = false) Integer id) {
		
		ModelAndView mav = new ModelAndView("");
		ProductTypeDTO productTypeDTO = new ProductTypeDTO();
		if(id == null) {
			mav.addObject("model", productTypeDTO);
			return mav;
		}else{
			productTypeDTO = productTypeService.findById(id);
			mav.addObject("model", productTypeDTO);
			return mav;
		}
	}
}
