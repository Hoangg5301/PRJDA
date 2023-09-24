package com.Bluewind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Bluewind.entity.ProductTypeEntity;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductTypeEntity, Integer>{

}
