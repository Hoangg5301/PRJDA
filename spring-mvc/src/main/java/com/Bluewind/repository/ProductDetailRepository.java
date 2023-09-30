package com.Bluewind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Bluewind.entity.ProductDetailEntity;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetailEntity, Integer>{
	@Query("select sum(p.quantity) from ProductDetailEntity p where p.productID = ?1")
	Integer sumQuatity(Integer id);
	
	@Modifying
	@Query("delete from ProductDetailEntity p where p.productID = ?1")
	Integer deleteProduct(Integer id);
	
	@Query("select p from ProductDetailEntity p where p.productID = ?1 and p.size = ?2 and p.color = ?3")
	ProductDetailEntity findByProduct(Integer idproduct, String size, String color);
}
