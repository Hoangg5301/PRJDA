package com.Bluewind.convert;

import org.springframework.stereotype.Component;

import com.Bluewind.dto.admin.ProductDetailDTO;
import com.Bluewind.entity.ProductDetailEntity;

@Component
public class ProductDetailConvert {
	public ProductDetailDTO toDTO(ProductDetailEntity productDetailEntity) {
		ProductDetailDTO productDetailDTO = new ProductDetailDTO();
		productDetailDTO.setProductDetailID(productDetailEntity.getProductDetailID());
		productDetailDTO.setProductID(productDetailEntity.getProductID());
		productDetailDTO.setSize(productDetailEntity.getSize());
		productDetailDTO.setQuantity(productDetailEntity.getQuantity());
		return productDetailDTO;
	}
	
	public ProductDetailEntity  toEntity(ProductDetailDTO productDetailDTO) {
		ProductDetailEntity productDetailEntity  = new ProductDetailEntity();
		productDetailEntity.setProductID(productDetailDTO.getProductID());
		productDetailEntity.setSize(productDetailDTO.getSize());
		productDetailEntity.setQuantity(productDetailDTO.getQuantity());
		return productDetailEntity;
	}
	
	public ProductDetailEntity toEntity(ProductDetailDTO productDetailDTO, ProductDetailEntity oldEntity) {
		oldEntity.setProductID(productDetailDTO.getProductID());
		oldEntity.setSize(productDetailDTO.getSize());
		oldEntity.setQuantity(productDetailDTO.getQuantity());
		return oldEntity;
	}
}
