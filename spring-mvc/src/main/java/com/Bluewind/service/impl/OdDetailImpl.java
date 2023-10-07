package com.Bluewind.service.impl;

import com.Bluewind.dto.OdDTO;
import com.Bluewind.dto.OdDetailDTO;
import com.Bluewind.dto.OrderRequest;
import com.Bluewind.dto.OrderResponse;
import com.Bluewind.entity.Od;
import com.Bluewind.entity.OdDetail;
import com.Bluewind.entity.ProductDetailEntity;
import com.Bluewind.repository.OdDetailRepository;
import com.Bluewind.repository.OdRepository;
import com.Bluewind.repository.ProductDetailRepository;
import com.Bluewind.service.OdService;
import lombok.RequiredArgsConstructor;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OdDetailImpl implements OdService {

    private final OdRepository odRepository;
    private final OdDetailRepository odDetailRepository;
    private final ProductDetailRepository productDetailRepository;

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
    @Transactional
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
                List<Integer> productDetailIds = new ArrayList<>();
                List<OdDetail> odDetails = request.getOdDetailDTOS().stream().map(o -> {
                    productDetailIds.add(o.getProductDetailId());
                    o.setOdId(odSaved.getId());
                    return objectMapper.convertValue(o, OdDetail.class);
                }).collect(Collectors.toList());

                List<ProductDetailEntity> productDetailEntities = productDetailRepository.findByProductDetailIDIsIn(productDetailIds);

                if (productDetailIds.size() != productDetailEntities.size()) {
                    System.out.println("productDetail is not existed!");
                    return null;
                }

                for (ProductDetailEntity productDetailEntity : productDetailEntities) {
                    OdDetail odDetail = odDetails.stream().filter(o -> productDetailEntity.getProductDetailID() == o.getProductDetailId()).findFirst().get();
                    if (productDetailEntity.getQuantity() < odDetail.getQuantity()) {
                        System.out.println("product quantity is out of remaining amount!");
                        return null;
                    }
                    productDetailEntity.setQuantity(productDetailEntity.getQuantity() - odDetail.getQuantity());
                }

                productDetailRepository.save(productDetailEntities);
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
