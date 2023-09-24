package com.Bluewind.service;

import java.util.List;

import com.Bluewind.dto.admin.ProductTypeDTO;


public interface IProductTypeService {
	List<ProductTypeDTO> findAll();
	ProductTypeDTO findById(Integer id);
	ProductTypeDTO insert(ProductTypeDTO dto);
	ProductTypeDTO update(ProductTypeDTO dto);
	void delete(Integer id);
}
