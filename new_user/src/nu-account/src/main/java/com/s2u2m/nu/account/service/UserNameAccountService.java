package com.s2u2m.nu.account.service;

import com.s2u2m.nu.account.config.account.UserNameAccountProperty;
import com.s2u2m.nu.account.controller.account.dto.UserNameAccountLoginDTO;
import com.s2u2m.nu.account.controller.account.dto.UserNameAccountRegDTO;
import com.s2u2m.nu.account.dao.UserNameAccountDAO;
import com.s2u2m.nu.account.entity.UserEntity;
import com.s2u2m.nu.account.entity.UserNameAccountEntity;
import com.s2u2m.nu.account.error.AccountErrorCodeEnum;
import com.s2u2m.nu.account.utils.formatcheck.CombineFormatChecker;
import com.s2u2m.nu.account.utils.formatcheck.checkers.PasswordFormatChecker;
import com.s2u2m.nu.account.utils.formatcheck.checkers.UserNameFormatChecker;
import com.s2u2u.nu.core.exception.ExceptionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * class UserNameAccountService
 *
 * @author xiayy860612
 * @date 2018/5/20
 */
@Service
public class UserNameAccountService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserNameAccountProperty accountProperty;

    @Autowired
    private UserNameAccountDAO accountDAO;

    @Transactional
    public UserEntity reg(UserNameAccountRegDTO regDTO) {
        // check username and password
        CombineFormatChecker checker = new CombineFormatChecker(
                new UserNameFormatChecker(regDTO.getUserName(),
                        accountProperty.getUserNameMinLength(),
                        accountProperty.getUserNameMaxLength()),
                new PasswordFormatChecker(regDTO.getPassword(),
                        accountProperty.getPasswordMinLength(),
                        accountProperty.getPasswordMaxLength())
        );
        if (!checker.check()) {
            throw ExceptionBuilder.build(AccountErrorCodeEnum.UserNameOrPasswordFormatInvalid);
        }

        // check if account existed
        UserNameAccountEntity entity = accountDAO.getByUserName(regDTO.getUserName());
        if (entity != null) {
            throw ExceptionBuilder.build(AccountErrorCodeEnum.UserNameAccountExisted,
                    String.format("username[%s] already existed", regDTO.getUserName()));
        }

        // create user
        UserEntity input = new UserEntity()
                .setNickName(regDTO.getUserName())
                .setGender(regDTO.getGender())
                .setBirthday(regDTO.getBirthday());
        UserEntity output = userService.create(input);

        // bind to account
        entity = new UserNameAccountEntity()
                .setUserId(output.getId())
                .setUserName(regDTO.getUserName())
                .setPassword(regDTO.getPassword());
        accountDAO.insert(entity);

        return output;
    }

    @Transactional(readOnly = true)
    public UserEntity login(UserNameAccountLoginDTO loginDTO) {

        UserNameAccountEntity accountEntity = accountDAO.getByUserName(loginDTO.getUserName());
        if (accountEntity == null) {
            throw ExceptionBuilder.build(AccountErrorCodeEnum.UserNameAccountNotExisted);
        }

        return userService.get(accountEntity.getUserId());
    }
}
