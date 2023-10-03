package com.Bluewind.controller.admin;

import com.Bluewind.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller(value = "orderDetailControllerOfAdmin")
public class OrderDetailController {
    @Autowired
    private MessageUtil messageUtil;

    @RequestMapping(value = "/home-order-admin", method = RequestMethod.GET)
    public ModelAndView displayList(HttpServletRequest request) {


    }
}
