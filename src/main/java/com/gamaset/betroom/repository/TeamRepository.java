package com.gamaset.betroom.repository;

import org.springframework.stereotype.Component;

import com.gamaset.betroom.repository.dao.JpaGenericDao;
import com.gamaset.betroom.repository.entity.domain.Team;


@Component
public class TeamRepository extends JpaGenericDao<Team, Long>{

	
}
