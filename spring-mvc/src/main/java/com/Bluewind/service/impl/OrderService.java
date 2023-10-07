package com.Bluewind.service.impl;

import com.Bluewind.convert.OrderConvert;
import com.Bluewind.convert.OrderDetailConvert;
import com.Bluewind.dto.OdDTO;
import com.Bluewind.dto.OrderRequest;
import com.Bluewind.dto.admin.OrderDTO;
import com.Bluewind.dto.admin.OrderDetailDTO;
import com.Bluewind.entity.Od;
import com.Bluewind.entity.OrderDetailEntity;
import com.Bluewind.entity.OrderEntity;
import com.Bluewind.repository.OdRepository;
import com.Bluewind.repository.OrderDetailRepository;
import com.Bluewind.repository.OrderRepository;
import com.Bluewind.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@EnableTransactionManagement(proxyTargetClass = true)
@Service
public class OrderService implements IOrderService {
    @Autowired
    private OdRepository odRepository;

    @Autowired OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderConvert orderConvert;

    @Autowired
    private OrderDetailConvert orderDetailConvert;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<OdDTO> findAll() {
        List<Od> listOrderEntity = odRepository.findAll();
        List<OdDTO> listOrderDTO = new ArrayList<>();

        for (Od orderEntity : listOrderEntity) {
            OdDTO orderDTO = new OdDTO();
            orderDTO.setId(orderEntity.getId());
            orderDTO.setFullName(orderEntity.getFullName());
            orderDTO.setAddress(orderEntity.getAddress());
            orderDTO.setPhoneNumber(orderEntity.getPhoneNumber());
            orderDTO.setCreatedDate(orderEntity.getCreatedDate());
            orderDTO.setStatus(orderEntity.getStatus());
            orderDTO.setAccountId(orderEntity.getAccountId());
            orderDTO.setDiscount(orderEntity.getDiscount());
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
//        OrderDTO orderDTO = request.getOrder();
//        List<OrderDetailDTO> orderDetailDTOS = request.getOrderDetail();
//        if (orderDTO != null) {
//            OrderEntity order = new OrderEntity();
//            OrderEntity oldOrder = new OrderEntity();
//
//            if (orderDTO.getOrderID() != null && orderDTO.getOrderID() != 0) {
//                oldOrder = orderRepository.findOne(order.getOrderID());
//            }
//
//            // new order
//            if (!orderDetailDTOS.isEmpty() && (orderDTO.getOrderID() == null || orderDTO.getOrderID() == 0 || oldOrder == null)) {
//                order = orderConvert.toEntity(orderDTO);
//                create(order, orderDetailDTOS);
//            } else if (oldOrder != null) {
//                // old order
//                orderDTO.setCreateTime("");
//                order = orderConvert.toEntity(orderDTO, oldOrder);
//                orderRepository.save(order);
//            }
//
//        }
    }

    private void create(OrderEntity order, List<OrderDetailDTO> orderDetailDTOS) {
        List<OrderDetailEntity> orderDetailEntities = orderDetailDTOS.stream().map(orderDetailDTO -> orderDetailConvert.toEntity(orderDetailDTO)).collect(Collectors.toList());


//        Query query = entityManager.createQuery(jpql1);
//        query.setParameter("fullName", "Nguyen Van A");
//        query.setParameter("createTime", "");
//        query.setParameter("status", "Wtaiting");
//        query.setParameter("address", "CHo nay");
//        query.setParameter("phoneNumber", "012345678");
//        query.setParameter("Discount", 12);
//        query.setParameter("IDTK", "012345678");

//        entityManager.getTransaction().begin();
//        query.executeUpdate();
//        entityManager.getTransaction().commit();

        OrderEntity entity = orderRepository.save(order);
        for (OrderDetailEntity detail : orderDetailEntities) {
            detail.setOrderID(entity.getOrderID());
        }
        orderDetailRepository.save(orderDetailEntities);
    }
}
