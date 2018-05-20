package com.s2u2u.nu.core.errors;

/**
 * enum CommonErrorCodeEnum
 *
 * @author xiayy860612
 * @date 2018/5/16
 */
public enum CommonErrorCodeEnum implements IErrorCodeEnum {
    ;

    @Override
    public int getTypeCode() {
        return S2u2mErrorTypeEnum.CommonError.getValue();
    }

    @Override
    public int getCode() {
        return this.code;
    }
    private int code;
    CommonErrorCodeEnum(int code) {
        this.code = code;
    }
}
