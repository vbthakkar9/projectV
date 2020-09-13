package com.account.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.account.finance.entity.TradeMaster;

@Repository
public interface TradeMasterRepository extends JpaRepository<TradeMaster, Integer>{

}


