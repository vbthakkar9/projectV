package com.account.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.account.finance.entity.Trade;
/**
 * 
 * @author Admin
 *
 */
@Repository
public interface TradeRepository  extends JpaRepository<Trade, Integer>{

}
