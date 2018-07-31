package com.s2u2m.example.statistic.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.s2u2m.example.statistic.dao")
public class MybatisConfig {
}
