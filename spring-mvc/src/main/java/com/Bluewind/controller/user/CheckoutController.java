package com.Bluewind.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "checkOutControllerOfUser")
public class CheckoutController {
    @RequestMapping(value = "/viewcheckout", method = RequestMethod.GET)
    public ModelAndView checkout(){
        ModelAndView mav = new ModelAndView("user/checkouts/checkout");
        return mav;
    }
}
