package com.s2u2m.nu.account.service;

import com.s2u2m.nu.account.dao.UserDAO;
import com.s2u2m.nu.account.entity.UserEntity;
import com.s2u2u.nu.core.utils.uid.SnowFlakeUidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.Instant;
import java.util.Date;

/**
 * class UserService
 *
 * @author xiayy860612
 * @date 2018/5/20
 */
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    SnowFlakeUidGenerator uidGenerator;

    @Transactional
    public UserEntity create(UserEntity entity) {
        String id = uidGenerator.nextIdByString();
        entity.setId(id);

        userDAO.insert(entity);
        return entity;
    }

    @Transactional(readOnly = true)
    public UserEntity get(String id) {
        return userDAO.getById(id);
    }
}
