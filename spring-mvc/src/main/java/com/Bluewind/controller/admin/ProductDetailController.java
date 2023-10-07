package com.Bluewind.controller.admin;

import com.Bluewind.dto.admin.ProductDetailDTO;
import com.Bluewind.service.IProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller(value = "productDetailControllerOfAdmin")
public class ProductDetailController {

    @Autowired
    private IProductDetailService productDetailService;

    @RequestMapping(value = "/home-productDetail-admin", method = RequestMethod.GET)
    public ModelAndView displayList(@RequestParam(value ="productID", required = false) Integer id,
                                    @RequestParam(value ="productName", required = false) String productName) {
     ModelAndView mav = new ModelAndView("admin/productDetails/productDetail");
        ProductDetailDTO productDetailDTO = new ProductDetailDTO();
        productDetailDTO.setProductName(productName);
        productDetailDTO.setProductID(id);
        productDetailDTO.setListResult(productDetailService.findListProductDetailByProduct(id));
        mav.addObject("model",productDetailDTO);
     return mav;
    }

    @RequestMapping(value = "/home-productDetailUpdate-admin", method = RequestMethod.GET)
    public ModelAndView getUpdate(@RequestParam(value ="productDetailID", required = false) Integer productDetailID, @RequestParam(value ="productID", required = false) Integer productID) {

        ModelAndView mav = new ModelAndView("admin/productDetails/productDetailEdit");
        ProductDetailDTO productDetailDTO = new ProductDetailDTO();
        productDetailDTO.setProductID(productID);
        if(productDetailID == null) {
            mav.addObject("model", productDetailDTO);
            return mav;
        }else{
            productDetailDTO = productDetailService.findoneID(productDetailID);
            mav.addObject("model", productDetailDTO);
            return mav;
        }
    }
}
