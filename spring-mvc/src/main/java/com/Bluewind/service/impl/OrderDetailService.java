package com.Bluewind.service.impl;

import com.Bluewind.convert.OrderConvert;
import com.Bluewind.convert.OrderDetailConvert;
import com.Bluewind.dto.admin.OrderDetailDTO;
import com.Bluewind.entity.OrderDetailEntity;
import com.Bluewind.entity.OrderEntity;
import com.Bluewind.repository.OrderDetailRepository;
import com.Bluewind.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrderDetailService implements IOrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    OrderDetailConvert orderDetailConvert;
    @Override
    public List<OrderDetailDTO> findOrderDetailEntitiesByOrderID(Integer orderID) {
        List<OrderDetailEntity> listOrderDetailEntity = orderDetailRepository.findOrderDetailEntitiesByOrderID(orderID);
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        List<OrderDetailDTO> lsitOrderDetailDTO = new ArrayList<>();
        for(OrderDetailEntity orderDetailEntity: listOrderDetailEntity){
            orderDetailDTO = orderDetailConvert.toDTO(orderDetailEntity);
            lsitOrderDetailDTO.add(orderDetailDTO);
        }
        return lsitOrderDetailDTO;
    }
}
