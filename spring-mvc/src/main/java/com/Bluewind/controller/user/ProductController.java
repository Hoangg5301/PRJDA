package com.Bluewind.controller.user;

import com.Bluewind.dto.admin.BrandDTO;
import com.Bluewind.dto.admin.ProductDTO;
import com.Bluewind.dto.admin.ProductDetailDTO;
import com.Bluewind.service.IProductDetailService;
import com.Bluewind.service.IProductService;
import com.Bluewind.service.impl.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller(value = "productControllerOfUser")
public class ProductController {

    private final IProductService iProductService;
    private final IProductDetailService iProductDetailService;
    private final BrandService brandService;

    public ProductController(IProductService iProductService, IProductDetailService iProductDetailService, BrandService brandService) {
        this.iProductService = iProductService;
        this.iProductDetailService = iProductDetailService;
        this.brandService = brandService;
    }

    @GetMapping("/products-by-name")
    public ModelAndView productByProductName(@RequestParam(value = "productName", required = false) String productName) {
        ModelAndView mav = new ModelAndView("");
        List<ProductDTO> productDTOS = iProductService.findByProductNameLike(productName);

        mav.addObject("productDTOS", productDTOS);
        return mav;
    }

    public Integer stringToNumber(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException numberFormatException) {
            System.out.println(str + " is not a number");
            return 0;
        }
    }

    @GetMapping("/products-by-filters")
    public ModelAndView productByFilters(
            @RequestParam(value = "brandID", required = false) String brandID,
            @RequestParam(value = "typeID", required = false) String typeID,
            @RequestParam(value = "price", required = false) String price,
            @RequestParam(value = "price2", required = false) String price2,
            @RequestParam(value = "orderBy", required = false) String orderBy
    ) {
        ModelAndView mav = new ModelAndView("");

        Integer brandIDInt = stringToNumber(brandID);
        Integer typeIDInt = stringToNumber(typeID);
        Integer priceInt = stringToNumber(price);
        Integer price2Int = stringToNumber(price2);
        boolean asc = stringToNumber(orderBy) == 0;

        List<ProductDTO> productDTOS = iProductService.findByBrandIDAndTypeIDAndPriceBetween(brandIDInt, typeIDInt, priceInt, price2Int, asc);
        List<BrandDTO> brandDTOS = brandService.findAll();
        mav.addObject("productDTOS", productDTOS);
        mav.addObject("brandDTOS", brandDTOS);
        return mav;
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

        List<ProductDetailDTO> productDetailDTOS = new ArrayList<>();
        if (productDTO != null) {
            productDetailDTOS = iProductDetailService.findAllByProductIds(List.of(productDTO.getProductID()));
        }
//
//        List<ProductDTO> listP = iProductService.findLast();
//        List<PostDTO> postDTOS = iPostService.getList();
//
//        mav.addObject("products", productDTOS);
//        mav.addObject("product", listP);

        mav.addObject("product", productDTO);
        mav.addObject("productDetailDTOS", productDetailDTOS);
        mav.addObject("productByBrand", productDTOS);
        return mav;
    }


}
