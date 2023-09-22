package com.Bluewind.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Bluewind.entity.BrandEntity;

public interface BrandRepository extends JpaRepository<BrandEntity, Integer>{
	
}
