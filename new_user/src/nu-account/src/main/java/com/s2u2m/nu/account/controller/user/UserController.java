package com.s2u2m.nu.account.controller.user;

import com.s2u2m.nu.account.controller.user.dto.UserInfoDTO;
import com.s2u2m.nu.account.entity.UserEntity;
import com.s2u2m.nu.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * class UserController
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public UserInfoDTO getUserInfo(@RequestHeader("token") String token) {
        String id = token;
        UserEntity userEntity = userService.get(id);
        return new UserInfoDTO()
                .setNickName(userEntity.getNickName())
                .setGender(userEntity.getGender())
                .setBirthday(userEntity.getBirthday());
    }
}
