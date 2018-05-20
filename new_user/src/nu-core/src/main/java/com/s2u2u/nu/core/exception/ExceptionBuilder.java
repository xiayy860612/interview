package com.s2u2u.nu.core.exception;

import com.s2u2u.nu.core.errors.IErrorCodeEnum;

public class ExceptionBuilder {

    // max error code, 2^TYPE_LF_SHIFT - 1
    private static final int TYPE_LF_SHIFT = 20;

    public static <ET extends IErrorCodeEnum> S2u2mSpringException build(
            ET errCode, String errMsg) {
        int code = errCode.getTypeCode() << TYPE_LF_SHIFT
                | errCode.getCode();
        S2u2mSpringException exception = new S2u2mSpringException();
        exception.setErrCode(code);
        exception.setErrMsg(errMsg);
        return exception;
    }

    public static <ET extends IErrorCodeEnum> S2u2mSpringException build(
            ET errCode) {
        return build(errCode, errCode.toString());
    }
}
