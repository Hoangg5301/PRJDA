package com.Bluewind.api.user;

import com.Bluewind.dto.OrderRequest;
import com.Bluewind.dto.OrderResponse;
import com.Bluewind.service.OdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "orderCheckout")
public class OrderAPI {

    @Autowired
    private OdService odService;

    @PostMapping("/order")
    public OrderResponse checkout(@RequestBody OrderRequest request) {
        OrderResponse orderResponse = new OrderResponse();
        if (request != null) {
            orderResponse = odService.saveOrder(request);
        }

        return orderResponse;
    }

}
