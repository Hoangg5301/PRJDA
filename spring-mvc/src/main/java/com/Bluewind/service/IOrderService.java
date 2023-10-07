package com.Bluewind.service;

import com.Bluewind.dto.OdDTO;
import com.Bluewind.dto.OrderRequest;
import com.Bluewind.dto.admin.BrandDTO;
import com.Bluewind.dto.admin.OrderDTO;
import com.Bluewind.entity.Od;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IOrderService {

    List<OdDTO> findAll();

    List<OrderDTO> findByPhoneNumber(String phoneNumber);

    List<OrderDTO> findAllByAccountID(Integer accountID);

    void saveOrder(OrderRequest request);

}
