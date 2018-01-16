package com.gamaset.betroom.repository.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gamaset.betroom.repository.entity.domain.SelectionMarketBet;

/**
 * 
 * @since 1.0.0
 * @author Christopher Rozario  (ˇ෴ˇ)
 * CREATE, TEST, COMPILE AND RUN.
 * @date 2018-jan-16
 */
@Repository
public interface SelectionMarketBetRepository extends CrudRepository<SelectionMarketBet, Long>{

	@Query("SELECT s FROM SelectionMarketBet s where s.marketBet.id = :marketId ORDER BY s.name")
	List<SelectionMarketBet> listByMarket(@Param("marketId") Long marketId);
	
}
