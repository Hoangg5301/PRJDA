package com.Bluewind.repository;

import java.util.List;

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

	@Query("select pd from ProductDetailEntity pd where pd.productID IN ?1")
	List<ProductDetailEntity> findAllByProductIds(List<Integer> ids);

    @Modifying
	@Query("update from ProductDetailEntity p set p.quantity = ?1 where p.productID = ?2 and p.size = ?3")
	void updateProductDetail(Integer quantity, Integer id, String size);
    
    @Query("select p from ProductDetailEntity p where p.productID = ?1 and p.size = ?2")
	ProductDetailEntity findByProduct(Integer id, String size);
}
