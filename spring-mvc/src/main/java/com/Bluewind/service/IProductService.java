package com.Bluewind.service;

import java.util.List;

import com.Bluewind.dto.admin.ProductDTO;


public interface IProductService {
	List<ProductDTO> findAll();
	ProductDTO findById(Integer id);
	ProductDTO insert(ProductDTO dto);
	ProductDTO update(ProductDTO dto);
	void delete(Integer id);
}
