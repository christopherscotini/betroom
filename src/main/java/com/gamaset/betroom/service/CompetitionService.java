package com.gamaset.betroom.service;

import static com.gamaset.betroom.infra.constants.ValidationConstants.COMPETITION_ID_MUST_NOT_BE_NULL;
import static com.gamaset.betroom.infra.constants.ValidationConstants.COUNTRY_ID_MUST_NOT_BE_NULL;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamaset.betroom.dto.CompetitionDTO;
import com.gamaset.betroom.dto.converter.ObjectsConverter;
import com.gamaset.betroom.repository.domain.CompetitionRepository;
import com.gamaset.betroom.repository.entity.domain.Competition;


/**
 * 
 * @since 1.0.0
 * @author Christopher Rozario  (ˇ෴ˇ)
 * CREATE, TEST, COMPILE AND RUN.
 * @date 2018-jan-16
 */
@Service
public class CompetitionService {

	@Autowired
	private CompetitionRepository competitionRepository;
//	@Autowired
//	private CompetitionSeasonRepository competitionSeasonRepository;
	
	
	public CompetitionDTO findOne(Long competitionId) {
		Objects.requireNonNull(competitionId, COMPETITION_ID_MUST_NOT_BE_NULL);
		
		return ObjectsConverter.convert(competitionRepository.findOne(competitionId));
	}

	public List<CompetitionDTO> listByCountry(Long countryId) {
		Objects.requireNonNull(countryId, COUNTRY_ID_MUST_NOT_BE_NULL);

		return ObjectsConverter.convertListCompetition(competitionRepository.listByCountry(countryId));
	}

	public List<CompetitionDTO> listAll(){
		return ObjectsConverter.convertListCompetition((List<Competition>) competitionRepository.findAll());
	}
	
//	public List<CompetitionSeasonDTO> competitionSeasons() {
//		return ObjectsConverter.convertListCompSeason(competitionSeasonRepository.findAll());
//	}
	
}
