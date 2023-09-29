package com.Bluewind.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Bluewind.convert.BrandConvert;
import com.Bluewind.dto.admin.BrandDTO;
import com.Bluewind.entity.BrandEntity;
import com.Bluewind.repository.BrandRepository;
import com.Bluewind.service.IBrandService;

@Service
public class BrandService implements IBrandService{
	@Autowired
	private BrandRepository brandRepository;
	@Autowired
	private BrandConvert brandConvert;

	@Override
	public List<BrandDTO> findAll(){
		List<BrandDTO> brandModelList = new ArrayList<>();
		List<BrandEntity> brandEntity = brandRepository.findAll();
		for(BrandEntity item : brandEntity ) {
			BrandDTO brandDTO = new BrandDTO();
			brandDTO = brandConvert.toDTO(item);
			brandModelList.add(brandDTO);
		}
		return brandModelList;
	}
	
	@Override
	public BrandDTO findById(Integer id) {
		BrandDTO brandDTO = new BrandDTO();
		BrandEntity brandEntity = brandRepository.findOne(id);
		brandDTO = brandConvert.toDTO(brandEntity);
		return brandDTO;
	}

	@Override
	@Transactional
	public BrandDTO insert(BrandDTO dto) {
		BrandEntity brandEntity = brandConvert.toEntity(dto);
		return brandConvert.toDTO(brandRepository.save(brandEntity));
	}

	@Override
	@Transactional
	public BrandDTO update(BrandDTO dto) {
		BrandEntity brandEntity = brandRepository.findOne(dto.getBrandID());
		brandEntity = brandConvert.toEntity(dto, brandEntity);
		return brandConvert.toDTO(brandRepository.save(brandEntity));
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		brandRepository.delete(id);
	}

	@Override
	@Transactional
	public void uploadAdd(String part) {
		Integer id = brandRepository.findLastId();
		brandRepository.uploadAdd(part, id);
	}

	@Override
	@Transactional
	public void uploadUpdate(Integer id, String part) {
		brandRepository.uploadUpdate(part, id);
	}


	


}
