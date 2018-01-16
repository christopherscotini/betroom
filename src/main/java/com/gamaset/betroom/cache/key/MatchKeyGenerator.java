package com.gamaset.betroom.cache.key;

import org.springframework.util.Assert;

/**
 * @since 1.0.0
 * @author Christopher Rozario  (ˇ෴ˇ)
 * CREATE, TEST, COMPILE AND RUN.
 * @date 2018-jan-09
 */
public class MatchKeyGenerator extends CacheKeyGenerator {

	private static final String patternIduKey;
	
	static {
		patternIduKey = KeyMarkup.SYSTEM_ENVIRONMENT + KeyConstants.SEPARATOR 
				+ KeyConstants.PRODUCT + KeyConstants.SEPARATOR + KeyMarkup.PRODUCT_ID;
		
	}
	
	public static String makeTheMatchMojo(String applicationEnvironmentPrefix, Long productId) {
        Assert.notNull(applicationEnvironmentPrefix, "applicationEnvironmentPrefix must not be null!");
        Assert.hasText(applicationEnvironmentPrefix, "applicationEnvironmentPrefix must not be empty!");
        Assert.notNull(productId, "productId must not be null!");

        String withSystem = mojo(KeyMarkup.SYSTEM_ENVIRONMENT, applicationEnvironmentPrefix, patternIduKey);
        
        return mojo(KeyMarkup.PRODUCT_ID, productId.toString(), withSystem);
    }
}
