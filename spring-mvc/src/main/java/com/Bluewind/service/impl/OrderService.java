package com.Bluewind.service.impl;

import com.Bluewind.convert.OrderConvert;
import com.Bluewind.convert.OrderDetailConvert;
import com.Bluewind.dto.OrderRequest;
import com.Bluewind.dto.admin.OrderDTO;
import com.Bluewind.dto.admin.OrderDetailDTO;
import com.Bluewind.entity.OrderDetailEntity;
import com.Bluewind.entity.OrderEntity;
import com.Bluewind.repository.OrderDetailRepository;
import com.Bluewind.repository.OrderRepository;
import com.Bluewind.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@EnableTransactionManagement(proxyTargetClass = true)
@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderConvert orderConvert;

    @Autowired
    private OrderDetailConvert orderDetailConvert;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<OrderDTO> findAll() {
        List<OrderEntity> listOrderEntity = orderRepository.findAll();
        List<OrderDTO> listOrderDTO = new ArrayList<>();
        OrderDTO orderDTO;
        for (OrderEntity orderEntity : listOrderEntity) {
            orderDTO = orderConvert.toDTO(orderEntity);
            listOrderDTO.add(orderDTO);
        }
        return listOrderDTO;
    }

    @Override
    public List<OrderDTO> findByPhoneNumber(String phoneNumber) {
        List<OrderEntity> orderEntities = orderRepository.findAllByPhoneNumber(phoneNumber);
        List<OrderDTO> orderDTOS = new ArrayList<>();
        if (!orderEntities.isEmpty()) {
            for (OrderEntity order : orderEntities) {
                orderDTOS.add(orderConvert.toDTO(order));

            }
        }
        return orderDTOS;
    }

    @Override
    public List<OrderDTO> findAllByAccountID(Integer accountID) {
        List<OrderDTO> orderDTOS = new ArrayList<>();
        List<OrderEntity> orderEntities = orderRepository.findAllByAccountID(accountID);
        if (!orderEntities.isEmpty()) {
            for (OrderEntity orderEntity : orderEntities) {
                orderDTOS.add(orderConvert.toDTO(orderEntity));
            }
        }

        return orderDTOS;
    }

    @Override
    @Transactional
    public void saveOrder(OrderRequest request) {
        OrderDTO orderDTO = request.getOrder();
        List<OrderDetailDTO> orderDetailDTOS = request.getOrderDetail();
        if (orderDTO != null) {
            OrderEntity order = new OrderEntity();
            OrderEntity oldOrder = new OrderEntity();

            if (orderDTO.getOrderID() != null && orderDTO.getOrderID() != 0) {
                oldOrder = orderRepository.findOne(order.getOrderID());
            }

            // new order
            if (!orderDetailDTOS.isEmpty() && (orderDTO.getOrderID() == null || orderDTO.getOrderID() == 0 || oldOrder == null)) {
                order = orderConvert.toEntity(orderDTO);
                create(order, orderDetailDTOS);
            } else if (oldOrder != null) {
                // old order
                orderDTO.setCreateTime(new Date());
                order = orderConvert.toEntity(orderDTO, oldOrder);
                orderRepository.save(order);
            }

        }
    }

    private void create(OrderEntity order, List<OrderDetailDTO> orderDetailDTOS) {
        List<OrderDetailEntity> orderDetailEntities = orderDetailDTOS.stream().map(orderDetailDTO -> orderDetailConvert.toEntity(orderDetailDTO)).collect(Collectors.toList());
        StringBuilder jpql1 = new StringBuilder( "INSERT INTO OrderEntity (fullName, createTime, status, address, phoneNumber, Discount, IDTK) VALUES (:fullName, :createTime, :status, :address, :phoneNumber, :Discount, :IDTK)");

        Query query = entityManager.createQuery(jpql1.toString());
        query.setParameter("fullName", "Nguyen Van A");
        query.setParameter("createTime", "");
        query.setParameter("status", "Wtaiting");
        query.setParameter("address", "CHo nay");
        query.setParameter("phoneNumber", "012345678");
        query.setParameter("Discount", 12);
        query.setParameter("IDTK", "012345678");

        entityManager.getTransaction().begin();
        query.executeUpdate();
        entityManager.getTransaction().commit();

        OrderEntity entity = orderRepository.save(order);
        for (OrderDetailEntity detail : orderDetailEntities) {
            detail.setOrderID(entity.getOrderID());
        }
        orderDetailRepository.save(orderDetailEntities);
    }
}
