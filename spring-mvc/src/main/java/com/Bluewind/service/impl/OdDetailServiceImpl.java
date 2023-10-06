package com.Bluewind.service.impl;

import com.Bluewind.dto.OdDetailDTO;
import com.Bluewind.entity.OdDetail;
import com.Bluewind.repository.OdDetailRepository;
import com.Bluewind.service.OdDetailService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OdDetailServiceImpl implements OdDetailService {

    private final OdDetailRepository odDetailRepository;
//    private final ObjectMapper objectMapper;

    public OdDetailServiceImpl(OdDetailRepository odDetailRepository) {
        this.odDetailRepository = odDetailRepository;
//        this.objectMapper = objectMapper;
    }

    @Override
    public List<OdDetailDTO> findAllByProductIDIs(List<Integer> productDetailIds) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<OdDetailDTO> odDetailDTOS = new ArrayList<>();
        List<OdDetail> odDetails = odDetailRepository.findByProductDetailIdIsIn(productDetailIds);
        if (!odDetails.isEmpty()) {
            for (OdDetail detail : odDetails) {
                odDetailDTOS.add(objectMapper.convertValue(detail, OdDetailDTO.class));
            }
        }
        return odDetailDTOS;
    }
}
