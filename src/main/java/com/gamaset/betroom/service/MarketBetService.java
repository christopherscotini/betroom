package com.gamaset.betroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamaset.betroom.dto.MarketBetDTO;
import com.gamaset.betroom.dto.converter.ObjectsConverter;
import com.gamaset.betroom.repository.domain.MarketBetRepository;
import com.gamaset.betroom.repository.entity.domain.MarketBet;

/**
 * 
 * @since 1.0.0
 * @author Christopher Rozario  (ˇ෴ˇ)
 * CREATE, TEST, COMPILE AND RUN.
 * @date 2018-jan-16
 */
@Service
public class MarketBetService {

	@Autowired
	private MarketBetRepository marketBetRepository;
	
	/**
	 * 
	 * @return
	 */
	public List<MarketBetDTO> listAll(){
		return ObjectsConverter.convertListMarketBet((List<MarketBet>) marketBetRepository.findAll());
	}
	
}
