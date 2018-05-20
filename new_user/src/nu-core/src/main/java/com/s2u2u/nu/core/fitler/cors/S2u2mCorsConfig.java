package com.s2u2u.nu.core.fitler.cors;

import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistration;

/**
 * class S2u2mCorsConfig
 *
 * @author xiayy860612
 * @date 2018/5/16
 */
public class S2u2mCorsConfig {

    public static void config(CorsRegistration corsRegistration) {
		corsRegistration
			.allowedOrigins("*")
			.allowedMethods("*")
			.allowedHeaders("*")
			.exposedHeaders(HttpHeaders.SET_COOKIE)
			.allowCredentials(true)
			.maxAge(3600);
	}
}
