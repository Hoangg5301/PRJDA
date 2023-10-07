package com.Bluewind.service;

import com.Bluewind.dto.OdDTO;
import com.Bluewind.dto.OrderRequest;
import com.Bluewind.dto.OrderResponse;

import java.util.List;

public interface OdService {
    List<OdDTO> findAll();

    List<OdDTO> findAllByAccountID(Integer accountID);

    OrderResponse saveOrder(OrderRequest request);

    OdDTO updatebyOdID(OdDTO dto);
}
