package com.Bluewind.api.admin;

import com.Bluewind.dto.admin.ProductDTO;
import com.Bluewind.dto.admin.ProductDetailDTO;
import com.Bluewind.service.IProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "productDetailAPIOfAdmin")
public class ProductDetailAPI {
    @Autowired
    private IProductDetailService productDetailService;

    @PostMapping("/api/productDetail")
    public ProductDetailDTO create(@RequestBody ProductDetailDTO productDetailDTO) {
        ProductDetailDTO productDetailDTOOut =  productDetailService.insert(productDetailDTO);
        return productDetailDTOOut;
    }

    @DeleteMapping("/api/productDetail")
    public void delete(@RequestBody ProductDetailDTO productDetailDTO) {
        productDetailService.delete(productDetailDTO);
    }
}
