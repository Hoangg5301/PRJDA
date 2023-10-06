package com.Bluewind.repository;

import com.Bluewind.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    List<OrderEntity> findAllByPhoneNumber(String phoneNumber);
    List<OrderEntity> findAllByAccountID(Integer accountID);
}
