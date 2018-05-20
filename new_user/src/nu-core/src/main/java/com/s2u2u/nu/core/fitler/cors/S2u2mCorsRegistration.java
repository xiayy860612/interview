package com.s2u2u.nu.core.fitler.cors;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistration;

/**
 * class S2u2mCorsRegistration
 *
 * @author xiayy860612
 * @date 2018/5/16
 */
public class S2u2mCorsRegistration extends CorsRegistration {
    public S2u2mCorsRegistration(String pathPattern) {
        super(pathPattern);
    }

    @Override
	public CorsConfiguration getCorsConfiguration() {
		return super.getCorsConfiguration();
	}
}
