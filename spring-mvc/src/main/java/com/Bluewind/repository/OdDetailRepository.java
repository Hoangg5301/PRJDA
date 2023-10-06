package com.Bluewind.repository;

import com.Bluewind.entity.OdDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface OdDetailRepository extends JpaRepository<OdDetail, Integer> {
    List<OdDetail> findByProductDetailIdIsIn(Collection<Integer> productDetailId);

}
