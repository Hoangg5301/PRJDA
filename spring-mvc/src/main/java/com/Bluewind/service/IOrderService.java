package com.Bluewind.service;

import com.Bluewind.dto.admin.BrandDTO;
import com.Bluewind.dto.admin.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IOrderService {

    List<OrderDTO> findAll();
}
