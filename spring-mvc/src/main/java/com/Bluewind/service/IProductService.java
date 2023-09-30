package com.Bluewind.service;

import java.util.List;

import com.Bluewind.dto.admin.ProductDTO;


public interface IProductService {
	List<ProductDTO> findAll();
	List<ProductDTO> findBrandName(ProductDTO dto);
	ProductDTO findById(Integer id);
	ProductDTO insert(ProductDTO dto);
	ProductDTO update(ProductDTO dto);
	void delete(Integer id);
	void uploadAdd(String path1, String path2, String path3, String path4);
	void uploadUpdate(String path1, String path2, String path3, String path4, Integer id);

	List<ProductDTO> findLast();

	List<ProductDTO> findAllByBrandID(Integer brandID);

}
