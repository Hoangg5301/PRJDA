package com.Bluewind.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Bluewind.entity.BrandEntity;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Integer>{
	
	@Modifying
	@Query("update BrandEntity b set b.brandImg = ?1 where b.brandID = ?2")
	void uploadUpdate(String part, Integer id);
	
	@Modifying
	@Query("update BrandEntity b set b.brandImg = ?1 where b.brandID = ?2")
	void uploadAdd(String part, Integer id);
	
	//lấy bản ghi cuối cùng.
	@Query("select MAX(b.brandID) from BrandEntity b order by b.brandID DESC")
	Integer findLastId();

	BrandEntity findByBrandID(Integer brandID);
}
