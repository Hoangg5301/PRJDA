package com.Bluewind.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bluewind.convert.ProductConvert;
import com.Bluewind.dto.admin.ProductDTO;
import com.Bluewind.entity.ProductEntity;
import com.Bluewind.repository.ProductRepository;
import com.Bluewind.service.IProductService;

@Service
public class ProductService implements IProductService{

	@Autowired
	private ProductConvert productConvert;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<ProductDTO> findAll() {
		List<ProductDTO> listProductDTO = new ArrayList<>();
		List<ProductEntity> productEntityList = productRepository.findAll();
		for(ProductEntity productEntity: productEntityList) {
			listProductDTO.add(productConvert.toDTO(productEntity));
		}
		return listProductDTO;
	}

	@Override
	public ProductDTO findById(Integer id) {
		return productConvert.toDTO(productRepository.findOne(id));
	}

	@Override
	public ProductDTO insert(ProductDTO dto) {
		
		return null;
	}

	@Override
	public ProductDTO update(ProductDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
}
