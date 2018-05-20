package com.s2u2u.nu.core.utils.uid;

import com.s2u2u.nu.core.errors.IErrorCodeEnum;
import com.s2u2u.nu.core.errors.S2u2mErrorTypeEnum;

/**
 * enum UidErrorCodeEnum
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
public enum UidErrorCodeEnum implements IErrorCodeEnum {
    GenerateUidError(1),
    ;

    @Override
    public int getTypeCode() {
        return S2u2mErrorTypeEnum.UidError.getValue();
    }

    @Override
    public int getCode() {
        return this.code;
    }
    private int code;
    UidErrorCodeEnum(int code) {
        this.code = code;
    }
}
