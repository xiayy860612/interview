package com.s2u2m.interview.ctm.exception;

/**
 * class ExceptionBuilder
 *
 * @author xiayy860612
 * @date 2018/5/17
 */
public class ExceptionBuilder {

    public static <ET extends IErrorCodeEnum> CmtException build(
            ET codeEnum, String msg) {
        int code = codeEnum.getCode();
        CmtException exception = new CmtException(code, msg);
        return exception;
    }

    public static <ET extends IErrorCodeEnum> CmtException build(
            ET errCode) {
        return build(errCode, errCode.toString());
    }
}
