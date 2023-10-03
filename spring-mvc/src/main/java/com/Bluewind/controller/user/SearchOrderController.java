package com.Bluewind.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "searchOrderControllerOfUser")
public class SearchOrderController {

    @RequestMapping(value = "/searchOrder", method = RequestMethod.GET)
    public ModelAndView display(){
        ModelAndView mav = new ModelAndView("user/searchOrders/searchOrder");

        return mav;
    }
}
