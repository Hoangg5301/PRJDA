package com.Bluewind.convert;

import com.Bluewind.dto.admin.OrderDTO;
import com.Bluewind.dto.admin.OrderDetailDTO;
import com.Bluewind.entity.OrderDetailEntity;
import com.Bluewind.entity.OrderEntity;

import java.util.Date;

public class OrderDetailConvert {
    public OrderDetailDTO toDTO(OrderDetailEntity orderDetailEntity) {
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        orderDetailDTO.setOrderDetailID(orderDetailEntity.getOrderDetailID());
        orderDetailDTO.setOrderID(orderDetailEntity.getOrderID());
        orderDetailDTO.setProductID(orderDetailEntity.getProductID());
        orderDetailDTO.setQuantity(orderDetailEntity.getQuantity());

        return orderDetailDTO;
    }

    public OrderDetailEntity toEntity(OrderDetailDTO OrderDetailDTO) {
        OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
        orderDetailEntity.setOrderDetailID(OrderDetailDTO.getOrderDetailID());
        orderDetailEntity.setOrderID(OrderDetailDTO.getOrderID());
        orderDetailEntity.setProductID(OrderDetailDTO.getProductID());
        orderDetailEntity.setQuantity(OrderDetailDTO.getQuantity());
        return orderDetailEntity;
    }

    public OrderDetailEntity toEntity(OrderDetailDTO OrderDetailDTO, OrderDetailEntity oldEntity) {

        oldEntity.setOrderID(OrderDetailDTO.getOrderID());
        oldEntity.setProductID(OrderDetailDTO.getProductID());
        oldEntity.setQuantity(OrderDetailDTO.getQuantity());
        return oldEntity;
    }
}
