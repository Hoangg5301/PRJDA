package com.Bluewind.service.impl;

import com.Bluewind.dto.OdDTO;
import com.Bluewind.dto.OdDetailDTO;
import com.Bluewind.dto.OrderRequest;
import com.Bluewind.dto.OrderResponse;
import com.Bluewind.entity.Od;
import com.Bluewind.entity.OdDetail;
import com.Bluewind.repository.OdDetailRepository;
import com.Bluewind.repository.OdRepository;
import com.Bluewind.service.OdService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OdDetailImpl implements OdService {

    private final OdRepository odRepository;
    private final OdDetailRepository odDetailRepository;
//    private final ObjectMapper objectMapper;

    public OdDetailImpl(OdRepository odRepository, OdDetailRepository odDetailRepository) {
        this.odRepository = odRepository;
        this.odDetailRepository = odDetailRepository;
//        this.objectMapper = objectMapper;
    }


    @Override
    public List<OdDTO> findAll() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<OdDTO> odDTOs = new ArrayList<>();
        List<Od> ods = odRepository.findAll();
        if (!ods.isEmpty()) {
            for (Od od : ods) {
                odDTOs.add(objectMapper.convertValue(od, OdDTO.class));
            }
        }
        return odDTOs;
    }

    @Override
    public List<OdDTO> findAllByAccountID(Integer accountID) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<OdDTO> odDTOs = new ArrayList<>();
        List<Od> ods = odRepository.findByAccountId(accountID);
        if (!ods.isEmpty()) {
            for (Od od : ods) {
                odDTOs.add(objectMapper.convertValue(od, OdDTO.class));
            }
        }
        return odDTOs;
    }

    @Override
    public OrderResponse saveOrder(OrderRequest request) {
        ObjectMapper objectMapper = new ObjectMapper();
        OrderResponse response = new OrderResponse();
        if (request != null && request.getOdDTO() != null) {
            Od od = objectMapper.convertValue(request.getOdDTO(), Od.class);
            od.setCreatedDate(new Date());
            Od odSaved = odRepository.save(od);
            if (odSaved == null) {
                return null;
            }
            if (!request.getOdDetailDTOS().isEmpty() && request.getOdDTO().getId() == 0) {
                List<OdDetail> odDetails = request.getOdDetailDTOS().stream().map(o -> {
                    o.setOdId(odSaved.getId());
                    return objectMapper.convertValue(o, OdDetail.class);
                }).collect(Collectors.toList());
                List<OdDetail> OdDetailSaved = odDetailRepository.save(odDetails);
                if (OdDetailSaved.isEmpty()) {
                    return null;
                }
                List<OdDetailDTO> odDetailDTOS = OdDetailSaved.stream().map(o -> objectMapper.convertValue(o, OdDetailDTO.class)).collect(Collectors.toList());
                response.setOdDetailDTOS(odDetailDTOS);
            }
            response.setOdDTO(objectMapper.convertValue(odSaved, OdDTO.class));

        }
        return response;
    }
}
