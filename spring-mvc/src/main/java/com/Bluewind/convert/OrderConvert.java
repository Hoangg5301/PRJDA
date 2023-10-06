package com.Bluewind.convert;

import com.Bluewind.dto.admin.OrderDTO;
import com.Bluewind.entity.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderConvert {

    public OrderDTO toDTO(OrderEntity orderEntity) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderID(orderEntity.getOrderID());
        orderDTO.setFullName(orderEntity.getFullName());
        orderDTO.setAccountID(orderDTO.getAccountID());
        orderDTO.setCreateTime(orderEntity.getCreateTime());
        orderDTO.setStatus(orderEntity.getStatus());
        orderDTO.setAddress(orderEntity.getAddress());
        orderDTO.setPhoneNumber(orderEntity.getPhoneNumber());
        orderDTO.setDiscount(orderEntity.getDiscount());
        return orderDTO;
    }

    public OrderEntity toEntity(OrderDTO orderDTO) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setFullName(orderDTO.getFullName());
        orderEntity.setAccountID(orderDTO.getAccountID());
        orderEntity.setCreateTime(orderDTO.getCreateTime());
        orderEntity.setStatus(orderDTO.getStatus());
        orderEntity.setAddress(orderDTO.getAddress());
        orderEntity.setDiscount(orderDTO.getDiscount());
        orderEntity.setPhoneNumber(orderDTO.getPhoneNumber());
        return orderEntity;
    }

    public OrderEntity toEntity(OrderDTO orderDTO, OrderEntity orderEntity) {

        orderEntity.setAccountID(orderDTO.getAccountID());
        orderEntity.setFullName(orderDTO.getFullName());
        orderEntity.setCreateTime(orderDTO.getCreateTime());
        orderEntity.setStatus(orderDTO.getStatus());
        orderEntity.setAddress(orderDTO.getAddress());
        orderEntity.setDiscount(orderDTO.getDiscount());
        orderEntity.setPhoneNumber(orderDTO.getPhoneNumber());
        return orderEntity;
    }
}
