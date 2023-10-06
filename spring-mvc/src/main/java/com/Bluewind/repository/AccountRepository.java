package com.Bluewind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Bluewind.entity.AccountEntity;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer>{
    @Query("SELECT a from AccountEntity a where a.userName =?1 and a.password = ?2")
    AccountEntity checkAccount(String userName, String password);
}
