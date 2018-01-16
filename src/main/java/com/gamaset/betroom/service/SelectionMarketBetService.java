package com.gamaset.betroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamaset.betroom.dto.SelectionMarketBetDTO;
import com.gamaset.betroom.dto.converter.ObjectsConverter;
import com.gamaset.betroom.repository.domain.SelectionMarketBetRepository;
import com.gamaset.betroom.repository.entity.domain.SelectionMarketBet;

/**
 * 
 * @since 1.0.0
 * @author Christopher Rozario  (ˇ෴ˇ)
 * CREATE, TEST, COMPILE AND RUN.
 * @date 2018-jan-16
 */
@Service
public class SelectionMarketBetService {

	@Autowired
	private SelectionMarketBetRepository selectionMarketBetRepository;
	
	/**
	 * 
	 * @param marketId 
	 * @return
	 */
	public List<SelectionMarketBetDTO> listByMarket(Long marketId){
		return ObjectsConverter.convertListSelectionMarketBet((List<SelectionMarketBet>) selectionMarketBetRepository.listByMarket(marketId));
	}
	
}
