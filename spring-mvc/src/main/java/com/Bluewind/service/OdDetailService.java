package com.Bluewind.service;

import com.Bluewind.dto.OdDetailDTO;

import java.util.List;

public interface OdDetailService {
    List<OdDetailDTO> findAllByProductIDIs(List<Integer> productDetailIds);
}
