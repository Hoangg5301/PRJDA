package com.Bluewind.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bluewind.repository.BrandRepository;
import com.Bluewind.service.IBrandService;

@Service
public class BrandService implements IBrandService{
	@Autowired
	private BrandRepository brandRepository;
	
	
}
