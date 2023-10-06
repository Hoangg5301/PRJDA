package com.Bluewind.api.user;

import com.Bluewind.common.CartCommon;
import com.Bluewind.dto.OrderRequest;
import com.Bluewind.dto.admin.OrderDTO;
import com.Bluewind.service.ICartService;
import com.Bluewind.service.IOrderDetailService;
import com.Bluewind.service.IOrderService;
import com.Bluewind.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "orderCheckout")
public class OrderAPI {

    @Autowired
    private IOrderService orderService;


    @PostMapping("/order")
    public void checkout(@RequestBody OrderRequest request) {
        if (request != null) {
            orderService.saveOrder(request);
        }
    }
}
