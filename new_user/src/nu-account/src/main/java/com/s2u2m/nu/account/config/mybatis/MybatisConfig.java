package com.s2u2m.nu.account.config.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.s2u2m.nu.account.dao")
public class MybatisConfig {
}
