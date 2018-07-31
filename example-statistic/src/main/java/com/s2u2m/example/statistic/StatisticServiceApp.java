package com.s2u2m.example.statistic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * StatisticServiceApp
 *
 * @author Amos Xia
 * @version x.x.x, 2018/7/31
 */
@EnableScheduling
@SpringBootApplication
public class StatisticServiceApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(StatisticServiceApp.class, args);
    }

}
