package com.Bluewind.controller.user;

import com.Bluewind.common.CartCommon;
import com.Bluewind.dto.CartProductDetail;
import com.Bluewind.dto.admin.CartDTO;
import com.Bluewind.service.ICartService;
import com.Bluewind.service.IProductDetailService;
import com.Bluewind.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller(value = "cartControllerOfUser")
public class CartController {

    private final ICartService iCartService;
    private final IProductDetailService iProductDetailService;
    private final IProductService iProductService;
    private final CartCommon cartCommon;

    public CartController(ICartService iCartService, IProductDetailService iProductDetailService, IProductService iProductService, CartCommon cartCommon) {
        this.iCartService = iCartService;
        this.iProductDetailService = iProductDetailService;
        this.iProductService = iProductService;
        this.cartCommon = cartCommon;
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public ModelAndView homePage(@RequestHeader("accountId") String accountId) {
        ModelAndView mav = new ModelAndView("user/carts/cart");
//        Integer accountId = Integer.parseInt(request.getParameter("accountId"));
//        String accountId = request.getHeader("accountId");
        List<CartProductDetail> cartProductDetails = cartCommon.getCarts(Integer.parseInt(accountId));
//        List<CartProductDetail> cartProductDetails = new ArrayList<>();
        mav.addObject("cartProductDetails", cartProductDetails);
        return new ModelAndView("user/carts/cart");
    }

    @RequestMapping(value = "/create-cart", method = RequestMethod.POST)
    private ModelAndView updateCart(@RequestBody CartDTO cartDTO) {
        ModelAndView mav = new ModelAndView("user/products/detail");
        Integer accountID = cartDTO.getAccountID();
        Integer productID = cartDTO.getProductID();
        Integer quantity = cartDTO.getQuantity();
        CartDTO dto = iCartService.updateByCartIDAndAccountID(accountID, productID, quantity);
        mav.addObject("cartSave", dto);
        return mav;
    }

    @RequestMapping(value = "/cart", method = RequestMethod.DELETE)
    private ModelAndView removeCart(@RequestBody Integer id) {
        ModelAndView mav = new ModelAndView("user/carts/cart");
        iCartService.deleteById(id);

        return mav;
    }
}
