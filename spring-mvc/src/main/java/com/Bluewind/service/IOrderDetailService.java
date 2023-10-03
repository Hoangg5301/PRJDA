package com.Bluewind.service;

import com.Bluewind.dto.admin.OrderDetailDTO;
import com.Bluewind.entity.OrderDetailEntity;

import java.util.List;


public interface IOrderDetailService{

    List<OrderDetailDTO> findOrderDetailEntitiesByOrderID(Integer orderID);

    List<OrderDetailDTO> findAllByProductIDIs(List<Integer> productIds);

}
