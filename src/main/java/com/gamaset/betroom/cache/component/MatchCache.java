package com.gamaset.betroom.cache.component;


import static com.gamaset.betroom.infra.log.LogConstants.CACHE_SERIALIZATION;
import static com.gamaset.betroom.infra.log.LogConstants.CLASS_METHOD;
import static com.gamaset.betroom.infra.log.LogConstants.CLASS_NAME;
import static com.gamaset.betroom.infra.log.LogConstants.REDIS_DOWN;
import static com.gamaset.betroom.infra.log.LogConstants.PARAMETERS.MATCH_ID;
import static com.gamaset.betroom.infra.log.LogEvent.create;

import java.io.IOException;
import java.util.Objects;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamaset.betroom.cache.health.CachePacemaker;
import com.gamaset.betroom.cache.key.MatchKeyGenerator;
import com.gamaset.betroom.infra.log.LogConstants;
import com.gamaset.betroom.infra.log.LogEvent;
import com.gamaset.betroom.vo.Match;

/**
 * @since 1.0.0
 * @author Christopher Rozario  (ˇ෴ˇ)
 * CREATE, TEST, COMPILE AND RUN.
 * @date 2018-jan-09
 */
@Component
public class MatchCache {

	private static final Logger LOG_METRIC = LogEvent.logger("METRIC");

    public static final String NAME = "cache.today.match";

    private final CachePacemaker cachePacemaker;
    private final Cache cache;
    private final String applicationEnvironmentPrefix;

    private ObjectMapper mapper;
	
    @Autowired
    public MatchCache(CacheManager cacheManager,
                        CachePacemaker cachePacemaker,
                        @Value("${spring.application.name}") String applicationName,
                        @Value("${spring.profiles}") String profile,
                        ObjectMapper mapper) {
        this.cachePacemaker = cachePacemaker;

        this.applicationEnvironmentPrefix = applicationName + ":" + profile;
        this.cache = cacheManager.getCache(this.applicationEnvironmentPrefix + ":" + NAME);

        this.mapper = mapper;
    }

    // --- GET ---
    public Match getPriceHistory(Long matchIdId) {
    	try {
    		if(cachePacemaker.cacheIsOK()) {
    			String key = MatchKeyGenerator.makeTheMatchMojo(applicationEnvironmentPrefix, matchIdId);
    			String value = cache.get(key, String.class);
    			
    			if (Objects.nonNull(value)) {
    				return mapper.readValue(value, Match.class);
    			}
    		}
		} catch (RedisConnectionFailureException e) {
            LOG_METRIC.error(create(REDIS_DOWN)
                    .add(CLASS_NAME, MatchCache.class.getName()).add(CLASS_METHOD, "get")
                    .add(MATCH_ID, matchIdId)
                    .add(e).build());
            cachePacemaker.freezeCache();
		} catch (IOException e) {
			LOG_METRIC.error(create(CACHE_SERIALIZATION)
                    .add(CLASS_NAME, MatchCache.class.getName()).add(CLASS_METHOD, "get")
                    .add(MATCH_ID, matchIdId)
                    .add(e).build());
		}
    	
    	return null;
    }

	// --- PUT --- 
    public boolean putPriceHistory(Long matchId, Match match) {
    	boolean result = false;
    	try {
    		if (cachePacemaker.cacheIsOK()) {
    			String key = MatchKeyGenerator.makeTheMatchMojo(
    					applicationEnvironmentPrefix, matchId);
    			String jsonMatch = mapper.writeValueAsString(match);
    			
    			if(Objects.nonNull(jsonMatch)) {
    				cache.put(key, jsonMatch);
    				result = true;
    			}
    		}
    	} catch (JsonProcessingException e) {
    		LOG_METRIC.error(create(CACHE_SERIALIZATION)
    				.add(CLASS_NAME, MatchCache.class.getName()).add(CLASS_METHOD, "put")
    				.add(LogConstants.PARAMETERS.MATCH_ID, matchId)
    				.add(e).build());
    	} catch (RedisConnectionFailureException e) {
    		LOG_METRIC.error(create(REDIS_DOWN)
    				.add(CLASS_NAME, MatchCache.class.getName()).add(CLASS_METHOD, "put")
    				.add(LogConstants.PARAMETERS.MATCH_ID, matchId)
    				.add(e).build());
    		cachePacemaker.freezeCache();
    	}
    	return result;
    }
    
}
