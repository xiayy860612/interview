package com.s2u2m.interview.ctm.exception;

/**
 * enum CmtErrorCodeEnum
 *
 * @author xiayy860612
 * @date 2018/5/17
 */
public enum CmtErrorCodeEnum implements IErrorCodeEnum{
    NoError(0),
    InternalError(1),
    InvalidParameter(2),
    InputAppParameterInvalid(3),

    ProposalInputFileNotExisted(101),
    ProposalReadLineError(102),
    ProposalUnitNotInvalid(103),
    ProposalUnitUnKnown(104),
    ProposalLineFormatError(105),

    LocalTimeSeqItemTimeRangeError(201),

    ;

    @Override
    public int getCode() {
        return this.code;
    }

    private int code;
    CmtErrorCodeEnum(int code) {
        this.code = code;
    }
}
