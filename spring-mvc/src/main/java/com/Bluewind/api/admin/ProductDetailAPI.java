package com.Bluewind.api.admin;

import com.Bluewind.dto.admin.ProductDTO;
import com.Bluewind.dto.admin.ProductDetailDTO;
import com.Bluewind.service.IProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "productDetailAPIOfAdmin")
public class ProductDetailAPI {
    @Autowired
    private IProductDetailService productDetailService;

    @PostMapping("/api/productDetail")
    public ProductDetailDTO create(@RequestBody ProductDetailDTO productDetailDTO) {
        ProductDetailDTO productDetailDTOOut =  productDetailService.insert(productDetailDTO);
        return productDetailDTOOut;
    }

    @PutMapping("/api/productDetail")
    public void update(@RequestBody ProductDetailDTO productDetailDTO){
        productDetailService.update(productDetailDTO);
    }

    @DeleteMapping("/api/productDetail")
    public void delete(@RequestBody ProductDetailDTO productDetailDTO) {
        productDetailService.delete(productDetailDTO);
    }
}
