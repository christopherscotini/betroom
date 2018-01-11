package com.gamaset.betroom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamaset.betroom.cache.component.CacheKeeper;
import com.gamaset.betroom.vo.Match;

/**
 * @since 1.0.0
 * @author Christopher Rozario  (ˇ෴ˇ)
 * CREATE, TEST, COMPILE AND RUN.
 * @date 2018-jan-09
 */
@Service
public class MatchService {

	@Autowired
	private CacheKeeper cache;

	
	public Match getMatch(Long matchId) {
		return cache.getMatch(matchId);
	}
	
	public void insertMatch(Match match) {
		cache.saveMatch(match.getId(), match);
	}
	
}
