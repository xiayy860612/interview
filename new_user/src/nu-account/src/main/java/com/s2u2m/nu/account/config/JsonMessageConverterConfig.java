package com.s2u2m.nu.account.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

/**
 * class JsonMessageConverterConfig
 *
 * @author xiayy860612
 * @date 2018/5/20
 */
@Configuration
public class JsonMessageConverterConfig {

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter =
                new MappingJackson2HttpMessageConverter();

        TimeZone timeZone = TimeZone.getTimeZone(TimeConfig.DefaultZone);
        SimpleDateFormat dateFormat = new SimpleDateFormat(TimeConfig.DateFormat);
        dateFormat.setTimeZone(timeZone);
        dateFormat.applyPattern(TimeConfig.DateFormat);

        converter.getObjectMapper().setTimeZone(timeZone);
        converter.getObjectMapper().setDateFormat(dateFormat);
        return converter;
    }
}
