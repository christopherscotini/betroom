package com.gamaset.betroom.endpoint;

import static com.gamaset.betroom.infra.log.LogConstants.ACCESS.HTTP_METHOD;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gamaset.betroom.dto.MarketBetDTO;
import com.gamaset.betroom.dto.SelectionMarketBetDTO;
import com.gamaset.betroom.infra.log.LogEvent;
import com.gamaset.betroom.service.MarketBetService;
import com.gamaset.betroom.service.SelectionMarketBetService;

/**
 * 
 * @since 1.0.0
 * @author Christopher Rozario  (ˇ෴ˇ)
 * CREATE, TEST, COMPILE AND RUN.
 * @date 2018-jan-15
 */
@RequestMapping("/markets")
@RestController
public class MarketBetEndpoint {

	private static final Logger LOG_ACCESS = LogEvent.logger("ACCESS");

	@Autowired
	private MarketBetService service;
	@Autowired
	private SelectionMarketBetService selectionMarketservice;
	
	@GetMapping(produces = { APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<MarketBetDTO> listAll() {

		LOG_ACCESS.info(LogEvent.create("/markets").add(HTTP_METHOD, GET).build());

		return service.listAll();
	}

	@GetMapping(value = "/{marketId}/selections", produces = { APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<SelectionMarketBetDTO> listSelectionsByMarket(@PathVariable("marketId") Long marketId) {
		
		LOG_ACCESS.info(LogEvent.create("/markets/{marketId}/selections").add(HTTP_METHOD, GET).build());
		
		return selectionMarketservice.listByMarket(marketId);
	}

}
