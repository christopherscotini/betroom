package com.gamaset.betroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamaset.betroom.cache.component.CacheKeeper;
import com.gamaset.betroom.repository.TeamRepository;
import com.gamaset.betroom.repository.entity.domain.Team;

/**
 * @since 1.0.0
 * @author Christopher Rozario (ˇ෴ˇ) 
 * CREATE, TEST, COMPILE AND RUN.
 * @date 2018-jan-09
 */
@Service
public class TeamService {

	@Autowired
	private CacheKeeper cache;

	@Autowired
	private TeamRepository teamRepository;

	public Team findOne(Long teamId) {
		return teamRepository.findById(teamId);
	}

	public List<Team> list() {
		return teamRepository.findAll();
	}

}
