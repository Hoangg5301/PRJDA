package com.Bluewind.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartProductDetail {
    private Integer cartId;
    private Integer accountId;
    private Integer productDetailId;
    private String name;
    private String size;
    private String image;
    private Integer price;
    private Integer quantity;


}
