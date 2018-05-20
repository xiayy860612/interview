package com.s2u2m.nu.account.config;

import com.s2u2u.nu.core.utils.uid.SnowFlakeUidGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * class UidGeneratorConfig
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
@Configuration
public class UidGeneratorConfig {

    @Bean
    SnowFlakeUidGenerator generator() throws Exception {
        Instant start = ZonedDateTime.of(
                2018, 5, 1,
                0,0,0, 0,
                ZoneId.of(TimeConfig.DefaultZone)).toInstant();
        return new SnowFlakeUidGenerator(start, 1);
    }
}
