package com.gamaset.betroom.endpoint;

import static com.gamaset.betroom.infra.log.LogConstants.ACCESS.HTTP_METHOD;
import static com.gamaset.betroom.infra.log.LogConstants.PARAMETERS.MATCH_ID;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gamaset.betroom.infra.log.LogEvent;
import com.gamaset.betroom.service.MatchService;
import com.gamaset.betroom.vo.Match;

/**
 * 
 * @since 1.0.0
 * @author Christopher Rozario  (ˇ෴ˇ)
 * CREATE, TEST, COMPILE AND RUN.
 * @date 2018-jan-08
 */
@RestController
public class InitEndpoint {

	private static final Logger LOG_ACCESS = LogEvent.logger("ACCESS");

	@Autowired
	private MatchService service;
	
	@GetMapping(value = "/test", produces = { APPLICATION_JSON_VALUE })
	@ResponseBody
	public String test() {

		LOG_ACCESS.info(LogEvent.create("/test").add(HTTP_METHOD, GET).build());

		return "I'm ready for the bets.";
	}

	@GetMapping(value = "/match/{matchId}", produces = { APPLICATION_JSON_VALUE })
	@ResponseBody
	public Match getMatch(@PathVariable("matchId") Long matchId) {
		LOG_ACCESS.info(LogEvent.create("/match/{matchId}").add(HTTP_METHOD, GET).add(MATCH_ID, matchId).build());
		
		return service.getMatch(matchId);
	}

	@PostMapping(value = "/match/{matchId}", produces = { APPLICATION_JSON_VALUE })
	@ResponseBody
	public void saveMatch(@PathVariable("matchId") Long matchId) {
		LOG_ACCESS.info(LogEvent.create("/match/{matchId}").add(HTTP_METHOD, POST).add(MATCH_ID, matchId).build());
		Match m = new Match();
		m.setId(matchId);
		m.setDescription("matc1 1 x 2 match2");
		service.insertMatch(m);
	}
	
	
}
