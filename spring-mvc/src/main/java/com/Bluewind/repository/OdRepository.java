package com.Bluewind.repository;

import com.Bluewind.entity.Od;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OdRepository extends JpaRepository<Od, Integer> {
    List<Od> findByAccountId(int accountId);

}
