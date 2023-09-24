package com.Bluewind.convert;

import org.springframework.stereotype.Component;

import com.Bluewind.dto.admin.ProductDTO;
import com.Bluewind.entity.ProductEntity;

@Component
public class ProductConvert {
	public ProductDTO toDTO(ProductEntity productEntity) {
		ProductDTO productDTO = new ProductDTO();
		
		productDTO.setProductID(productEntity.getProductID());
		productDTO.setProductName(productEntity.getProductName());
		productDTO.setPrice(productEntity.getPrice());
		productDTO.setSize(productEntity.getSize());
		productDTO.setColor(productEntity.getColor());
		productDTO.setQuantity(productEntity.getQuantity());
		productDTO.setMeterial(productEntity.getMeterial());
		productDTO.setWeight(productEntity.getWeight());
		productDTO.setGender(productEntity.getGender());
		productDTO.setDescribeDetail(productEntity.getDescribeDetail());
		productDTO.setImg1(productEntity.getImg1());
		productDTO.setImg2(productEntity.getImg2());
		productDTO.setImg3(productEntity.getImg3());
		productDTO.setImg4(productEntity.getImg4());
		productDTO.setBrandID(productEntity.getBrandID());
		productDTO.setTypeID(productEntity.getTypeID());
		return productDTO;
	}
	
	public ProductEntity toEntity(ProductDTO productDTO) {
		ProductEntity productEntity  = new ProductEntity();
		
		productEntity.setProductName(productDTO.getProductName());
		productEntity.setPrice(productDTO.getPrice());
		productEntity.setSize(productDTO.getSize());
		productEntity.setColor(productDTO.getColor());
		productEntity.setQuantity(productDTO.getQuantity());
		productEntity.setMeterial(productDTO.getMeterial());
		productEntity.setWeight(productDTO.getWeight());
		productEntity.setGender(productDTO.getGender());
		productEntity.setDescribeDetail(productDTO.getDescribeDetail());
		productEntity.setImg1(productDTO.getImg1());
		productEntity.setImg2(productDTO.getImg2());
		productEntity.setImg3(productDTO.getImg3());
		productEntity.setImg4(productDTO.getImg4());
		productEntity.setBrandID(productDTO.getBrandID());
		productEntity.setTypeID(productDTO.getTypeID());
		return productEntity;
	}
	
	public ProductEntity toEntity(ProductDTO productDTO, ProductEntity oldEntity) {
		oldEntity.setProductName(productDTO.getProductName());
		oldEntity.setPrice(productDTO.getPrice());
		oldEntity.setSize(productDTO.getSize());
		oldEntity.setColor(productDTO.getColor());
		oldEntity.setQuantity(productDTO.getQuantity());
		oldEntity.setMeterial(productDTO.getMeterial());
		oldEntity.setWeight(productDTO.getWeight());
		oldEntity.setGender(productDTO.getGender());
		oldEntity.setDescribeDetail(productDTO.getDescribeDetail());
		oldEntity.setImg1(productDTO.getImg1());
		oldEntity.setImg2(productDTO.getImg2());
		oldEntity.setImg3(productDTO.getImg3());
		oldEntity.setImg4(productDTO.getImg4());
		oldEntity.setBrandID(productDTO.getBrandID());
		oldEntity.setTypeID(productDTO.getTypeID());
		return oldEntity;
	}
}
