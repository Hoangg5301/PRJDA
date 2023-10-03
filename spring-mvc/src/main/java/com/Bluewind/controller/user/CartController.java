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

    @RequestMapping(value = "/cart", method = RequestMethod.POST)
    public ModelAndView homePage(@RequestParam("accountId") String data) {
        ModelAndView mav = new ModelAndView("user/carts/cart");
        List<CartProductDetail> cartProductDetails = cartCommon.getCarts(Integer.parseInt(data));
        mav.addObject("cartProductDetails", cartProductDetails);
        return mav;
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
