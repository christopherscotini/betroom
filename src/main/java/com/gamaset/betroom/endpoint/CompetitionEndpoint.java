package com.gamaset.betroom.endpoint;

import static com.gamaset.betroom.infra.log.LogConstants.ACCESS.HTTP_METHOD;
import static com.gamaset.betroom.infra.log.LogConstants.PARAMETERS.COMPETITION_ID;
import static com.gamaset.betroom.infra.log.LogConstants.PARAMETERS.COUNTRY_ID;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gamaset.betroom.dto.CompetitionDTO;
import com.gamaset.betroom.infra.log.LogEvent;
import com.gamaset.betroom.service.CompetitionService;

/**
 * 
 * @since 1.0.0
 * @author Christopher Rozario  (ˇ෴ˇ)
 * CREATE, TEST, COMPILE AND RUN.
 * @date 2018-jan-15
 */
@RestController
public class CompetitionEndpoint {

	private static final Logger LOG_ACCESS = LogEvent.logger("ACCESS");

	@Autowired
	private CompetitionService service;

	@GetMapping(value = "/competitions/{competitionId}", produces = { APPLICATION_JSON_VALUE })
	@ResponseBody
	public CompetitionDTO byId(@PathVariable("competitionId") Long competitionId) {

		LOG_ACCESS.info(LogEvent.create("/country/{contryId}/competitions/{competitionId}").add(HTTP_METHOD, GET)
				.add(COMPETITION_ID, competitionId).build());

		return service.findOne(competitionId);
	}

	@GetMapping(value = "/country/{contryId}/competitions", produces = { APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<CompetitionDTO> listByCountry(@PathVariable("contryId") Long contryId) {

		LOG_ACCESS.info(LogEvent.create("/country/{contryId}/competitions").add(HTTP_METHOD, GET)
				.add(COUNTRY_ID, contryId).build());

		return service.listByCountry(contryId);
	}

	@GetMapping(produces = { APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<CompetitionDTO> listAll() {
		LOG_ACCESS.info(LogEvent.create("/competitions").add(HTTP_METHOD, GET).build());

		return service.listAll();
	}

}
