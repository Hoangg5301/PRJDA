package com.Bluewind.convert;

import org.springframework.stereotype.Component;

import com.Bluewind.dto.admin.BrandDTO;
import com.Bluewind.entity.BrandEntity;

@Component
public class BrandConvert {
	
	public BrandDTO toDTO(BrandEntity brandEntity) {
		BrandDTO brandDTO = new BrandDTO();
		brandDTO.setBrandID(brandEntity.getBrandID());
		brandDTO.setBrandName(brandEntity.getBrandName());
		brandDTO.setBrandImg(brandEntity.getBrandImg());
		return brandDTO;
	}
	
	public BrandEntity  toEntity(BrandDTO brandDTO) {
		BrandEntity brandEntity  = new BrandEntity();
		brandEntity.setBrandName(brandDTO.getBrandName());
		brandEntity.setBrandImg(brandDTO.getBrandImg());
		return brandEntity;
	}
	
	public BrandEntity toEntity(BrandDTO brandDTO, BrandEntity oldEntity) {
		oldEntity.setBrandName(brandDTO.getBrandName());
		oldEntity.setBrandImg(brandDTO.getBrandImg());
		return oldEntity;
	}
}
