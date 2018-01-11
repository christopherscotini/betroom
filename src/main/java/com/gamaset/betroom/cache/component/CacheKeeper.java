package com.gamaset.betroom.cache.component;

import static com.gamaset.betroom.infra.constants.ExceptionConstants.FAIL_TO_PROCESS_PUT_MATCH;
import static com.gamaset.betroom.infra.constants.ValidationConstants.MATCH_MUST_NOT_BE_NULL;
import static com.gamaset.betroom.infra.constants.ValidationConstants.MATCH_ID_MUST_NOT_BE_NULL;
import static org.springframework.util.Assert.notNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamaset.betroom.infra.exception.FailPutPriceHistoryCacheException;
import com.gamaset.betroom.vo.Match;

@Component
public class CacheKeeper {
	
	private final MatchCache cache;
	
	@Autowired
	public CacheKeeper(MatchCache cache) {
		this.cache = cache;
	}
	
	/*
	 * --- GET
	 */
	/**
	 * 
	 * @param categoryId
	 * @return {@link EditorialBrandsResponse}
	 * @throws llegalArgumentException
	 */
	public Match getMatch(Long matchId) {
		notNull(matchId, MATCH_ID_MUST_NOT_BE_NULL);
		
		return cache.getPriceHistory(matchId);
	}
	
	public void saveMatch(Long matchId, Match match) {
		notNull(matchId, MATCH_ID_MUST_NOT_BE_NULL);
		notNull(match, MATCH_MUST_NOT_BE_NULL);
		
		boolean process = cache.putPriceHistory(matchId, match);
		
		if (!process) {
			throw new FailPutPriceHistoryCacheException(FAIL_TO_PROCESS_PUT_MATCH);
		}
	}
	

}
