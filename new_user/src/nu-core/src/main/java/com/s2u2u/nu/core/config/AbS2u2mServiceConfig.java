package com.s2u2u.nu.core.config;

import com.s2u2u.nu.core.fitler.cors.S2u2mCorsConfig;
import com.s2u2u.nu.core.fitler.cors.S2u2mCorsRegistration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Amos Xia
 * @date 2018/4/10
 */
public abstract class AbS2u2mServiceConfig extends WebMvcConfigurerAdapter {

    @Override
	public void addCorsMappings(CorsRegistry registry) {
		// 配置CorsInterceptor的CORS参数
		S2u2mCorsConfig.config(registry.addMapping("/**"));
	}

	@Bean
	public CorsFilter corsFilter() {
        S2u2mCorsRegistration registration = new S2u2mCorsRegistration("/**");
        S2u2mCorsConfig.config(registration);

    	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", registration.getCorsConfiguration());
		return new CorsFilter(source);
	}
}
