package com.Bluewind.service;

import com.Bluewind.dto.admin.OrderDetailDTO;

import java.util.List;


public interface IOrderDetailService{

    List<OrderDetailDTO> findOrderDetailEntitiesByOrderID(Integer orderID);

}
