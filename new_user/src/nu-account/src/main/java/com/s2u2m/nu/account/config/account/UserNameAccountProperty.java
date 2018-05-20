package com.s2u2m.nu.account.config.account;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * class UserNameAccountProperty
 *
 * @author xiayy860612
 * @date 2018/5/20
 */
@Configuration
@PropertySource("classpath:config/account.properties")
@ConfigurationProperties(prefix = "nu.account.username")
@Getter
@Setter
public class UserNameAccountProperty {
    private int userNameMinLength;
    private int userNameMaxLength;

    private int passwordMinLength;
    private int passwordMaxLength;
}
