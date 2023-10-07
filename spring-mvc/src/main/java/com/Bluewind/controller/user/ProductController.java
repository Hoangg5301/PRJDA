package com.Bluewind.controller.user;

import com.Bluewind.common.CartCommon;
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
    private final CartCommon cartCommon;

    public ProductController(IProductService iProductService, IProductDetailService iProductDetailService, BrandService brandService, CartCommon cartCommon) {
        this.iProductService = iProductService;
        this.iProductDetailService = iProductDetailService;
        this.brandService = brandService;
        this.cartCommon = cartCommon;
    }

    @GetMapping("/products-by-name")
    public ModelAndView productByProductName(@RequestParam(value = "productName", required = false) String productName) {
        ModelAndView mav = new ModelAndView("");
        List<ProductDTO> productDTOS = iProductService.findByProductNameLike(productName);

        mav.addObject("productDTOS", productDTOS);
        return mav;
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

        Integer brandIDInt = cartCommon.stringToNumber(brandID);
        Integer typeIDInt = cartCommon.stringToNumber(typeID);
        Integer priceInt = cartCommon.stringToNumber(price);
        Integer price2Int = cartCommon.stringToNumber(price2);
        boolean asc = cartCommon.stringToNumber(orderBy) == 0;

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
