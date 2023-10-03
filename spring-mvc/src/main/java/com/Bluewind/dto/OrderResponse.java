package com.Bluewind.dto;

import com.Bluewind.dto.admin.OrderDTO;
import com.Bluewind.dto.admin.OrderDetailDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderResponse {
    private OrderDTO orderDTO;
    private List<OrderDetailDTO> orderDetailDTOS;
}
