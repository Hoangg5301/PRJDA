package com.Bluewind.repository;

import com.Bluewind.dto.admin.OrderDetailDTO;
import com.Bluewind.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Integer> {

    public List<OrderDetailEntity> findOrderDetailEntitiesByOrderID(Integer orderID);
}
