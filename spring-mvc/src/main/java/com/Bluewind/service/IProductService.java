package com.Bluewind.service;

import java.util.Collection;
import java.util.List;

import com.Bluewind.dto.admin.ProductDTO;
import com.Bluewind.entity.ProductEntity;


public interface IProductService {
	List<ProductDTO> findAll();
	List<ProductDTO> findBrandName(ProductDTO dto);
	Integer findlastID();
	ProductDTO findById(Integer id);
	ProductDTO insert(ProductDTO dto);
	ProductDTO update(ProductDTO dto);
	void delete(Integer id);
	void uploadAdd(String path1, String path2, String path3, String path4);
	void uploadUpdate(String path1, String path2, String path3, String path4, Integer id);

	List<ProductDTO> findLast();

	List<ProductDTO> findAllByBrandID(Integer brandID);

	List<ProductDTO> findAllByProductIds(List<Integer> ids);

	List<ProductDTO> findByProductNameLike(String productName);

	List<ProductDTO> findByBrandIDAndTypeIDAndPriceBetween(Integer brandID, Integer typeID, Integer price, Integer price2, boolean asc);

}
