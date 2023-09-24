package com.Bluewind.convert;

import org.springframework.stereotype.Component;

import com.Bluewind.dto.admin.ProductTypeDTO;
import com.Bluewind.entity.ProductTypeEntity;

@Component
public class ProductTypeConvert {
	public ProductTypeDTO toDTO(ProductTypeEntity productTypeEntity) {
		ProductTypeDTO producTypeDTO = new ProductTypeDTO();
		producTypeDTO.setTypeID(productTypeEntity.getTypeID());
		producTypeDTO.setTypeName(productTypeEntity.getTypeName());
		return producTypeDTO;
	}
	
	public ProductTypeEntity toEntity(ProductTypeDTO producTypeDTO) {
		ProductTypeEntity productTypeEntity  = new ProductTypeEntity();
		productTypeEntity.setTypeName(producTypeDTO.getTypeName());
		return productTypeEntity;
	}
	
	public ProductTypeEntity toEntity(ProductTypeDTO producTypeDTO, ProductTypeEntity oldEntity) {
		oldEntity.setTypeName(producTypeDTO.getTypeName());
		return oldEntity;
	}
}
