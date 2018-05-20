package com.s2u2m.nu.account.dao;

import com.s2u2m.nu.account.entity.UserNameAccountEntity;

/**
 * interface UserNameAccountDAO
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
public interface UserNameAccountDAO {
    UserNameAccountEntity getByUserName(String userName);

    UserNameAccountEntity getByUserId(String userId);

    int insert(UserNameAccountEntity entity);
}
