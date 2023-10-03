package com.Bluewind.service.impl;

import com.Bluewind.convert.OrderConvert;
import com.Bluewind.dto.admin.OrderDTO;
import com.Bluewind.entity.OrderEntity;
import com.Bluewind.repository.OrderRepository;
import com.Bluewind.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderConvert orderConvert;
    @Override
    public List<OrderDTO> findAll() {
        List<OrderEntity> listOrderEntity = orderRepository.findAll();
        List<OrderDTO> listOrderDTO = new ArrayList<>();
        OrderDTO orderDTO;
        for(OrderEntity orderEntity : listOrderEntity){
            orderDTO = orderConvert.toDTO(orderEntity);
            listOrderDTO.add(orderDTO);
        }
        return listOrderDTO;
    }
}
