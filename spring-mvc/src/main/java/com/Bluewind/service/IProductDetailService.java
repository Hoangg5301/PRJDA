package com.Bluewind.service;

import java.util.List;

import com.Bluewind.dto.admin.ProductDetailDTO;

public interface IProductDetailService {
	List<ProductDetailDTO> findAll();
	ProductDetailDTO insert(ProductDetailDTO dto);
	void delete(ProductDetailDTO dto);
	List<ProductDetailDTO> findAllByProductIds(List<Integer> ids);
	List<ProductDetailDTO> findListProductDetailByProduct(Integer id);
}


