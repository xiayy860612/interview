package com.s2u2u.nu.core.enumhandler;

import com.s2u2u.nu.core.errors.IErrorCodeEnum;
import com.s2u2u.nu.core.errors.S2u2mErrorTypeEnum;

/**
 * enum EnumHandlerErrorCodeEnum
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
public enum EnumHandlerErrorCodeEnum implements IErrorCodeEnum {
    IntEnumItemNotExisted(1)
    ;

    @Override
    public int getTypeCode() {
        return S2u2mErrorTypeEnum.EnumHandlerError.getValue();
    }

    @Override
    public int getCode() {
        return 0;
    }
    private int code;
    EnumHandlerErrorCodeEnum(int code) {
        this.code = code;
    }
}
