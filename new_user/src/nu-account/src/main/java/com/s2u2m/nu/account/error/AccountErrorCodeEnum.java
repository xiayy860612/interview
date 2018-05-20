package com.s2u2m.nu.account.error;

import com.s2u2m.nu.account.AccountServiceApp;
import com.s2u2u.nu.core.enumhandler.IIntEnum;
import com.s2u2u.nu.core.errors.IErrorCodeEnum;
import com.s2u2u.nu.core.errors.S2u2mErrorTypeEnum;

/**
 * enum AccountErrorCodeEnum
 *
 * @author xiayy860612
 * @date 2018/5/20
 */
public enum AccountErrorCodeEnum implements IErrorCodeEnum {

    UserNameOrPasswordFormatInvalid(101),
    UserNameAccountExisted(102),
    UserNameAccountNotExisted(103),
    ;

    private int code;
    AccountErrorCodeEnum(int code) {
        this.code = code;
    }

    @Override
    public int getTypeCode() {
        return S2u2mErrorTypeEnum.UserCustomError.getValue() + 1;
    }

    @Override
    public int getCode() {
        return this.code;
    }
}
