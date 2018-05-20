package com.s2u2m.nu.account.controller.account;

import com.s2u2m.nu.account.controller.account.dto.LoginInfoDTO;
import com.s2u2m.nu.account.controller.account.dto.UserNameAccountLoginDTO;
import com.s2u2m.nu.account.controller.account.dto.UserNameAccountRegDTO;
import com.s2u2m.nu.account.entity.UserEntity;
import com.s2u2m.nu.account.service.UserNameAccountService;
import com.s2u2u.nu.core.serialization.S2u2mResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * class UserNameAccountController
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
@RestController
@RequestMapping(value = "/account/username")
public class UserNameAccountController {

    @Autowired
    private UserNameAccountService accountService;

    @S2u2mResponseBody
    @PostMapping(value = "/reg")
    public LoginInfoDTO reg(@RequestBody UserNameAccountRegDTO regDTO) {
        UserEntity entity = accountService.reg(regDTO);
        // get token
        String token = entity.getId();
        return new LoginInfoDTO().setToken(token);
    }

    @PostMapping(value = "/login")
    public LoginInfoDTO login(@RequestBody UserNameAccountLoginDTO loginDTO) {
        UserEntity entity = accountService.login(loginDTO);
        return new LoginInfoDTO().setToken(entity.getId());
    }
}
