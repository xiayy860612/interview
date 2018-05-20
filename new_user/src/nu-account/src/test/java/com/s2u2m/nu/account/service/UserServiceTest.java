package com.s2u2m.nu.account.service;

import com.s2u2m.nu.account.base.AbSpringTest;
import com.s2u2m.nu.account.dao.UserDAO;
import com.s2u2m.nu.account.entity.UserEntity;
import com.s2u2m.nu.account.enums.GenderEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.w3c.dom.UserDataHandler;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;

public class UserServiceTest extends AbSpringTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserDAO userDAO;

    @Test
    public void create_success() {
        String nickName = "test";
        GenderEnum gender = GenderEnum.Female;

        doReturn(1).when(userDAO).insert(any(UserEntity.class));

        UserEntity input = new UserEntity()
                .setNickName(nickName)
                .setGender(gender);

        UserEntity entity = userService.create(input);

        assertNotNull(entity.getId());
        assertNotEquals("", entity.getId());

        assertNotNull(entity.getCreateTime());
        assertFalse(entity.getDeleteFlag());
    }
}