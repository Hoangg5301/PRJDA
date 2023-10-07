package com.Bluewind.common;

import com.Bluewind.dto.CartProductDetail;
import com.Bluewind.dto.admin.CartDTO;
import com.Bluewind.dto.admin.ProductDTO;
import com.Bluewind.dto.admin.ProductDetailDTO;
import com.Bluewind.service.ICartService;
import com.Bluewind.service.IProductDetailService;
import com.Bluewind.service.IProductService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class CartCommon {

    private final ICartService iCartService;
    private final IProductDetailService iProductDetailService;
    private final IProductService iProductService;

    public CartCommon(ICartService iCartService, IProductDetailService iProductDetailService, IProductService iProductService) {
        this.iCartService = iCartService;
        this.iProductDetailService = iProductDetailService;
        this.iProductService = iProductService;
    }

    public List<CartProductDetail> getCarts(Integer accountId) {
        List<CartDTO> cartDTOS = iCartService.findAllByAccountID(accountId);

        List<Integer> productDetailIds = new ArrayList<>();
        if (!cartDTOS.isEmpty()) {
            for (CartDTO dto : cartDTOS) {
                productDetailIds.add(dto.getProductID());
            }
        }

        List<ProductDetailDTO> productDetailDTOS = iProductDetailService.findByProductDetailIDIsIn(productDetailIds);

        List<Integer> pIds = new ArrayList<>();
        if (!productDetailDTOS.isEmpty()) {
            for (ProductDetailDTO dto : productDetailDTOS) {
                pIds.add(dto.getProductID());
            }
        }

        List<ProductDTO> productDTOS = iProductService.findAllByProductIds(pIds);

        List<CartProductDetail> cartProductDetails = new ArrayList<>();

        for (CartDTO dto : cartDTOS) {
            ProductDetailDTO productDetailDTO = productDetailDTOS.stream().filter(p -> p.getProductDetailID() == dto.getProductID()).findFirst().get();
            ProductDTO productDTO = productDTOS.stream().filter(p -> Objects.equals(p.getProductID(), productDetailDTO.getProductID())).findFirst().get();

            CartProductDetail cartProductDetail = CartProductDetail.builder()
                    .cartId(dto.getCartID())
                    .accountId(accountId)
                    .productDetailId(productDetailDTO.getProductDetailID())
                    .name(productDTO.getProductName())
                    .size(productDetailDTO.getSize())
                    .image(productDTO.getImg1())
                    .price(productDTO.getPrice())
                    .quantity(dto.getQuantity())
                    .build();
            cartProductDetails.add(cartProductDetail);
        }
        return cartProductDetails;
    }
}
