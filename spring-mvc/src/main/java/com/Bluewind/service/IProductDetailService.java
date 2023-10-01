package com.Bluewind.service;

import java.util.List;

import com.Bluewind.dto.admin.ProductDetailDTO;

public interface IProductDetailService {
	List<ProductDetailDTO> findAll();
	public ProductDetailDTO insert(ProductDetailDTO dto);
}


