package com.s2u2m.interview.ctm.exception;

/**
 * class CmtException
 *
 * @author xiayy860612
 * @date 2018/5/17
 */
public class CmtException extends RuntimeException {
    private int code = 0;

    public CmtException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
