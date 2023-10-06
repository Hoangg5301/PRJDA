package com.Bluewind.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequest {
    private OdDTO odDTO;
    private List<OdDetailDTO> odDetailDTOS;
}
