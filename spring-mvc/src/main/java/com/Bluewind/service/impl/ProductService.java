package com.Bluewind.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public ProductDTO insert(ProductDTO dto) {
		ProductEntity productEntity = productConvert.toEntity(dto);
		return productConvert.toDTO(productRepository.save(productEntity));
	}

	@Override
	@Transactional
	public ProductDTO update(ProductDTO dto) {
		ProductEntity oldEntity = productRepository.findOne(dto.getProductID());
		oldEntity = productConvert.toEntity(dto, oldEntity);
		oldEntity = productRepository.save(oldEntity);
		return productConvert.toDTO(oldEntity);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		productRepository.delete(id);
	}
	
}
