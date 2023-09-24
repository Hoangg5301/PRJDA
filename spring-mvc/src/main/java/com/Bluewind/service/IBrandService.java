package com.Bluewind.service;

import java.util.List;

import com.Bluewind.dto.admin.BrandDTO;

public interface IBrandService {
	List<BrandDTO> findAll();
	BrandDTO findById(Integer id);
	BrandDTO insert(BrandDTO dto);
	BrandDTO update(BrandDTO dto);
	void delete(Integer id);
}
