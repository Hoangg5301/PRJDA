package com.Bluewind.controller.admin;

import com.Bluewind.dto.admin.ProductDetailDTO;
import com.Bluewind.service.impl.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller(value = "productDetailControllerOfAdmin")
public class ProductDetailController {

    @Autowired
    ProductDetailService productDetailService;

    @RequestMapping(value = "/home-productDetail-admin", method = RequestMethod.GET)
    public ModelAndView displayList(HttpServletRequest request) {
     ModelAndView mav = new ModelAndView("admin/productDetails/productDetail");
        ProductDetailDTO productDetailDTO = new ProductDetailDTO();
        Integer id = Integer.parseInt(request.getParameter("productID"));
        String productName = request.getParameter("productName");
        productDetailDTO.setProductName(productName);
        productDetailDTO.setListResult(productDetailService.findListProductDetailByProduct(id));
        mav.addObject("model",productDetailDTO);
     return mav;
    }
}
