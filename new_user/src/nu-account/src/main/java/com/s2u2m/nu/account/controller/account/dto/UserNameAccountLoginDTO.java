package com.s2u2m.nu.account.controller.account.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * class UserNameAccountRegDTO
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
@Getter
@Setter
@Accessors(chain = true)
public class UserNameAccountLoginDTO {
    private String userName;
    private String password;
}
