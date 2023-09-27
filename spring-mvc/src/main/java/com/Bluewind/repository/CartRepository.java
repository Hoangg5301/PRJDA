package com.Bluewind.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Bluewind.entity.CartEntity;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Integer>{
	
	//@Query("Select * from cart WHERE IDTK = ?1 and IDProduct = ?2 ")
	//CartEntity findCartEntityByAccountIDAndProductID(Integer accountID, Integer productID);
	
	@Query("select c from CartEntity c where c.accountID = ?1 and c.productID = ?2")
	CartEntity find(Integer a, Integer b);
	
	@Query("select c from CartEntity c where c.accountID = ?1")
	List<CartEntity> findByAccountID(Integer a);
}
