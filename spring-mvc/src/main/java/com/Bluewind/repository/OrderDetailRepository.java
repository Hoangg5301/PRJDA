package com.Bluewind.repository;

import com.Bluewind.dto.admin.OrderDetailDTO;
import com.Bluewind.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Integer> {

    List<OrderDetailEntity> findOrderDetailEntitiesByOrderID(Integer orderID);

    @Query("select p from ProductDetailEntity p where p.productID in ?1")
    List<OrderDetailEntity> findAllByProductIDIs(List<Integer> productIds);
}
