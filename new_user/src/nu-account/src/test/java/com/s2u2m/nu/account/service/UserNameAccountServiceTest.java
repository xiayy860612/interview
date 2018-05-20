package com.s2u2m.nu.account.service;

import com.s2u2m.nu.account.base.AbSpringTest;
import com.s2u2m.nu.account.controller.account.dto.UserNameAccountRegDTO;
import com.s2u2m.nu.account.dao.UserNameAccountDAO;
import com.s2u2m.nu.account.entity.UserEntity;
import com.s2u2m.nu.account.entity.UserNameAccountEntity;
import com.s2u2m.nu.account.enums.GenderEnum;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;

public class UserNameAccountServiceTest extends AbSpringTest {

    @Autowired
    private UserNameAccountService accountService;

    @MockBean
    private UserService userService;

    @MockBean
    private UserNameAccountDAO accountDAO;

    @Test
    public void reg__success() {
        String nickName = "test123456";
        String password = "test@123456";
        String id = "123456";
        GenderEnum gender = GenderEnum.Female;

        // mock
        doReturn(null).when(accountDAO).getByUserName(anyString());
        doReturn(1).when(accountDAO).insert(any(UserNameAccountEntity.class));

        doReturn(new UserEntity().setId(id).setNickName(nickName))
                .when(userService).create(any(UserEntity.class));

        UserNameAccountRegDTO regDTO = new UserNameAccountRegDTO()
                .setUserName(nickName)
                .setPassword(password)
                .setGender(gender);

        UserEntity entity = accountService.reg(regDTO);

        assertTrue(entity.getId().equals(id));
        assertNotNull(entity.getCreateTime());
        assertFalse(entity.getDeleteFlag());

        assertTrue(entity.getNickName().equals(nickName));
    }
}