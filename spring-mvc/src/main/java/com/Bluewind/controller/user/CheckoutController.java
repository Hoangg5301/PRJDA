package com.Bluewind.controller.user;

import com.Bluewind.common.CartCommon;
import com.Bluewind.dto.CartProductDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@Controller(value = "checkOutControllerOfUser")
public class CheckoutController {

    private final CartCommon cartCommon;

    @RequestMapping(value = "/viewcheckout", method = RequestMethod.POST)
    public ModelAndView checkout(@RequestParam("accountId") String accountId){
        ModelAndView mav = new ModelAndView("user/checkouts/checkout");
        List<CartProductDetail> cartProductDetails = cartCommon.getCarts(Integer.parseInt(accountId));
        mav.addObject("cartProductDetails", cartProductDetails);
        return mav;
    }
}
