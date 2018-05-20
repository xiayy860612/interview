package com.s2u2m.nu.account.controller.user.dto;

import com.s2u2m.nu.account.enums.GenderEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * class UserInfoDTO
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
@Getter
@Setter
@Accessors(chain = true)
public class UserInfoDTO {
    private String nickName;
    private GenderEnum gender;
    private Date birthday;
}
