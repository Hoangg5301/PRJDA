package com.Bluewind.controller.user;

import com.Bluewind.dto.admin.PostDTO;
import com.Bluewind.dto.admin.ProductDTO;
import com.Bluewind.service.IPostService;
import com.Bluewind.service.IProductService;
import org.jboss.logging.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller(value = "productControllerOfUser")
public class ProductController {

    private final IProductService iProductService;
    private final IPostService iPostService;

    public ProductController(IProductService iProductService, IPostService iPostService) {
        this.iProductService = iProductService;
        this.iPostService = iPostService;
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ModelAndView homePage(HttpServletRequest httpServletRequest) {
        ModelAndView mav = new ModelAndView("user/products/detail");
//        System.out.println("id" + id);

        ProductDTO productDTO = iProductService.findById(Integer.parseInt(httpServletRequest.getParameter("id")));

        List<ProductDTO> productDTOS = new ArrayList<>();
        if (productDTO != null && productDTO.getBrandID() != null) {
             productDTOS = iProductService.findAllByBrandID(productDTO.getBrandID());
        }
//
//        List<ProductDTO> listP = iProductService.findLast();
//        List<PostDTO> postDTOS = iPostService.getList();
//
//        mav.addObject("products", productDTOS);
//        mav.addObject("product", listP);
        mav.addObject("product", productDTO);
        mav.addObject("productByBrand", productDTOS);
        return mav;
    }


}
