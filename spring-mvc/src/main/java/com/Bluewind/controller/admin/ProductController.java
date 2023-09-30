package com.Bluewind.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Bluewind.dto.admin.ProductDTO;
import com.Bluewind.service.IProductService;
import com.Bluewind.util.MessageUtil;

@Controller(value = "productControllerOfAdmin")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/home-product-admin", method = RequestMethod.GET)
	public ModelAndView productPage(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView("admin/products/product");
		ProductDTO productDTO = new ProductDTO();
		productDTO.setListResult(productService.findAll());
		productDTO.setListResult(productService.findBrandName(productDTO));
		
		if(request.getParameter("message") != null) {
			Map<String, String> mapMessage = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", mapMessage.get("message"));
			mav.addObject("alert", mapMessage.get("alert"));
		}
		mav.addObject("model",productDTO);
		return mav;
		
	}
	
	@RequestMapping(value = "/home-productupdate-admin", method = RequestMethod.GET)
	public ModelAndView getUpdate(@RequestParam(value ="id", required = false) Integer id) {
		
		ModelAndView mav = new ModelAndView("admin/products/productEdit");
		ProductDTO productDTO = new ProductDTO();
		if(id == null) {
			mav.addObject("model", productDTO);
			return mav;
		}else{
			productDTO = productService.findById(id);
			mav.addObject("model", productDTO);
			return mav;
		}
	}
}
