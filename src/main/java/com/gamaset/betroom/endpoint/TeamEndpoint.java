package com.gamaset.betroom.endpoint;

import static com.gamaset.betroom.infra.log.LogConstants.ACCESS.HTTP_METHOD;
import static com.gamaset.betroom.infra.log.LogConstants.PARAMETERS.TEAM_ID;
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

import com.gamaset.betroom.infra.log.LogEvent;
import com.gamaset.betroom.repository.entity.domain.Team;
import com.gamaset.betroom.service.TeamService;

/**
 * 
 * @since 1.0.0
 * @author Christopher Rozario  (ˇ෴ˇ)
 * CREATE, TEST, COMPILE AND RUN.
 * @date 2018-jan-15
 */
@RequestMapping("/teams")
@RestController
public class TeamEndpoint {

	private static final Logger LOG_ACCESS = LogEvent.logger("ACCESS");

	@Autowired
	private TeamService service;
	
	@GetMapping(value = "/{teamId}", produces = { APPLICATION_JSON_VALUE })
	@ResponseBody
	public Team byId(@PathVariable("teamId") Long teamId) {

		LOG_ACCESS.info(LogEvent.create("/teams/" + teamId).add(HTTP_METHOD, GET).add(TEAM_ID, teamId).build());

		return service.findOne(teamId);
	}

	@GetMapping(produces = { APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Team> getAll() {
		LOG_ACCESS.info(LogEvent.create("/teams").add(HTTP_METHOD, GET).build());
		
		return service.list();
	}
	
}
