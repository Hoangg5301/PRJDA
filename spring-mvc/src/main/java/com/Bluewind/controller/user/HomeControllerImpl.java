package com.Bluewind.controller.user;

import com.Bluewind.dto.admin.PostDTO;
import com.Bluewind.dto.admin.ProductDTO;
import com.Bluewind.service.IPostService;
import com.Bluewind.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller(value = "homeControllerOfUser")
public class HomeControllerImpl {

    private final IProductService iProductService;
    private final IPostService iPostService;

    public HomeControllerImpl(IProductService iProductService, IPostService iPostService) {
        this.iProductService = iProductService;
        this.iPostService = iPostService;
    }

    @RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView mav = new ModelAndView("user/home");
        List<ProductDTO> productDTOS = iProductService.findAll();
        List<ProductDTO> listP = iProductService.findLast();
        List<PostDTO> postDTOS = iPostService.getList();

        mav.addObject("products", productDTOS);
        mav.addObject("product", listP);
        mav.addObject("posts", postDTOS);
        return mav;
    }


}
