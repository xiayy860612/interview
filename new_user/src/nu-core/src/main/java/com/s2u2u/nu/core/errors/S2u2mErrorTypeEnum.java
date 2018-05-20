package com.s2u2u.nu.core.errors;

import com.s2u2u.nu.core.enumhandler.IIntEnum;

/**
 * class S2u2mErrorTypeEnum
 *
 * @author xiayy860612
 * @date 2018/5/14
 */
public enum S2u2mErrorTypeEnum implements IIntEnum {
    CommonError(0),
    UidError(1),
    EnumHandlerError(2),


    // max error type value
    UserCustomError(1000);


    @Override
    public int getValue() {
        return this.value;
    }

    private int value;
    S2u2mErrorTypeEnum(int value) {
        this.value = value;
    }
}
