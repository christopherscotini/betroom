package com.gamaset.betroom.repository.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gamaset.betroom.repository.entity.domain.Team;

/**
 * 
 * @since 1.0.0
 * @author Christopher Rozario  (ˇ෴ˇ)
 * CREATE, TEST, COMPILE AND RUN.
 * @date 2018-jan-16
 */
@Repository
public interface TeamRepository extends CrudRepository<Team, Long>{
	
}
