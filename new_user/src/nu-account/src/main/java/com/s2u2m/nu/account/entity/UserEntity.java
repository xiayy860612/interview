package com.s2u2m.nu.account.entity;

import com.s2u2m.nu.account.enums.GenderEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.Instant;
import java.util.Date;

/**
 * class UserEntity
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
@Getter
@Setter
@Accessors(chain = true)
public class UserEntity {
    private String id;
    private String nickName;
    private GenderEnum gender = GenderEnum.Unknown;
    private Date birthday;
    private Date createTime = Date.from(Instant.now());
    private Date updateTime;
    private Boolean deleteFlag = false;
}
