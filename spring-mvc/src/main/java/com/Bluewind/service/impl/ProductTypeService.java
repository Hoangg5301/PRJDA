package com.Bluewind.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Bluewind.convert.ProductTypeConvert;
import com.Bluewind.dto.admin.ProductTypeDTO;
import com.Bluewind.entity.ProductTypeEntity;
import com.Bluewind.repository.ProductTypeRepository;
import com.Bluewind.service.IProductTypeService;

@Service
public class ProductTypeService implements IProductTypeService{

	@Autowired
	private ProductTypeRepository productTypeRepository;
	@Autowired
	private ProductTypeConvert productTypeConvert;
	
	
	@Override
	public List<ProductTypeDTO> findAll() {
		List<ProductTypeDTO> listProductType = new ArrayList<>();
		List<ProductTypeEntity> productTypeEntityList = productTypeRepository.findAll();
		for(ProductTypeEntity productTypeEntity: productTypeEntityList) {
			listProductType.add(productTypeConvert.toDTO(productTypeEntity));
		}
		
		return listProductType;
	}

	@Override
	public ProductTypeDTO findById(Integer id) {
		ProductTypeEntity productTypeEntity= productTypeRepository.findOne(id);
		ProductTypeDTO productTypeDTO = productTypeConvert.toDTO(productTypeEntity);
		return productTypeDTO;
	}

	@Override
	@Transactional
	public ProductTypeDTO insert(ProductTypeDTO dto) {
		ProductTypeEntity productTypeEntity = productTypeConvert.toEntity(dto);
		return productTypeConvert.toDTO(productTypeRepository.save(productTypeEntity));
	}

	@Override
	@Transactional
	public ProductTypeDTO update(ProductTypeDTO dto) {
		ProductTypeEntity oldEntity = productTypeRepository.findOne(dto.getTypeID());
		oldEntity = productTypeConvert.toEntity(dto, oldEntity);
		oldEntity = productTypeRepository.save(oldEntity);
		return productTypeConvert.toDTO(oldEntity);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		productTypeRepository.delete(id);
	}
	
}
