package com.Bluewind.dto;

import com.Bluewind.dto.admin.OrderDTO;
import com.Bluewind.dto.admin.OrderDetailDTO;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnoreType;

import java.util.List;

@Getter
@Setter
public class OrderRequest {
    private OrderDTO order;
    private List<OrderDetailDTO> orderDetail;
}
