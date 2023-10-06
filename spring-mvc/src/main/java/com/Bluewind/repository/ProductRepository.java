package com.Bluewind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Bluewind.entity.ProductEntity;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{
	@Modifying
	@Query("update ProductEntity p set p.img1 = ?1, p.img2 = ?2, p.img3 = ?3, p.img4 = ?4 where p.productID = ?5")
	void uploadUpdate(String pat1, String path2, String path3, String path4, Integer id);
	
	@Modifying
	@Query("update ProductEntity p set p.img1 = ?1, p.img2 = ?2, p.img3 = ?3, p.img4 = ?4 where p.productID = ?5")
	void uploadAdd(String path1, String path2, String path3, String path4, Integer id);
	
	//lấy bản ghi cuối cùng.
	@Query("select MAX(p.productID) from ProductEntity p order by p.productID DESC")
	Integer findLastId();

	List<ProductEntity> findTop4ByOrderByProductIDDesc();

	List<ProductEntity> findTop4ByBrandID(Integer brandID);

	@Query("select p from ProductEntity p where p.productID IN ?1")
	List<ProductEntity> findAllByProductIds(List<Integer> ids);

	List<ProductEntity> findByProductNameIsContaining(String productName);

	List<ProductEntity> findByBrandIDAndTypeIDAndPriceBetweenOrderByPriceAsc(Integer brandID, Integer typeID, Integer price, Integer price2);

	List<ProductEntity> findByBrandIDAndTypeIDAndPriceBetweenOrderByPriceDesc(Integer brandID, Integer typeID, Integer price, Integer price2);

}
