package com.gamaset.betroom.endpoint;

import static com.gamaset.betroom.infra.log.LogConstants.ACCESS.HTTP_METHOD;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gamaset.betroom.infra.log.LogEvent;

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

	@GetMapping(value = "/test", produces = { APPLICATION_JSON_VALUE })
	@ResponseBody
	public String test() {

		LOG_ACCESS.info(LogEvent.create("/test").add(HTTP_METHOD, GET).build());

		return "I'm ready for the bets.";
	}
}
