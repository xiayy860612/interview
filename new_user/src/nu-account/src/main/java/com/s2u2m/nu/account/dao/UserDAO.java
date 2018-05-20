package com.s2u2m.nu.account.dao;

import com.s2u2m.nu.account.entity.UserEntity;

/**
 * interface UserDAO
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
public interface UserDAO {
    int insert(UserEntity entity);

    UserEntity getById(String id);
}
