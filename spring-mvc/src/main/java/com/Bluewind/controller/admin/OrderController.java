package com.Bluewind.controller.admin;

import com.Bluewind.dto.OdDTO;
import com.Bluewind.dto.admin.OrderDTO;
import com.Bluewind.entity.Od;
import com.Bluewind.service.IOrderService;
import com.Bluewind.service.IOrderService;
import com.Bluewind.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.Bluewind.util.MessageUtil;


import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller(value = "orderControllerOfAdmin")
public class OrderController {

    @Autowired
    private MessageUtil messageUtil;
    @Autowired
    private IOrderService orderService;
    @RequestMapping(value = "/home-order-admin", method = RequestMethod.GET)
    public ModelAndView displayList(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("admin/orders/order");
        List<OdDTO> orderDTO = (orderService.findAll());

//        if(request.getParameter("message") != null) {
//            Map<String, String> mapMessage = messageUtil.getMessage(request.getParameter("message"));
//            mav.addObject("message", mapMessage.get("message"));
//            mav.addObject("alert", mapMessage.get("alert"));
//        }
        mav.addObject("model",orderDTO);
        return mav;
    }
}
