package com.Bluewind.service;

import java.util.List;

import com.Bluewind.dto.admin.ProductDetailDTO;
import com.Bluewind.entity.ProductDetailEntity;

public interface IProductDetailService {
	List<ProductDetailDTO> findAll();
	void update(ProductDetailDTO dto);
	ProductDetailDTO insert(ProductDetailDTO dto);
	void delete(ProductDetailDTO dto);
	List<ProductDetailDTO> findAllByProductIds(List<Integer> ids);
	List<ProductDetailDTO> findByProductDetailIDIsIn(List<Integer> ids);
	List<ProductDetailDTO> findListProductDetailByProduct(Integer id);
	ProductDetailDTO findoneID(Integer id);
}


