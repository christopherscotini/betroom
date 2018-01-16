package com.gamaset.betroom.repository.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gamaset.betroom.repository.entity.domain.Competition;

/**
 * 
 * @since 1.0.0
 * @author Christopher Rozario  (ˇ෴ˇ)
 * CREATE, TEST, COMPILE AND RUN.
 * @date 2018-jan-16
 */
@Repository
public interface CompetitionRepository extends CrudRepository<Competition, Long>{

	@Query("SELECT c FROM Competition c where c.country.id = :countryId ORDER BY c.name")
	List<Competition> listByCountry(@Param("countryId") Long countryId);
	
}
