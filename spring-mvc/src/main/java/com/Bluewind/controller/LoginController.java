package com.Bluewind.controller;

import com.Bluewind.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private MessageUtil messageUtil;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("login");
        if(request.getParameter("message") != null) {
            Map<String, String> mapMessage = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", mapMessage.get("message"));
            mav.addObject("alert", mapMessage.get("alert"));
        }
        return mav;
    }
}
