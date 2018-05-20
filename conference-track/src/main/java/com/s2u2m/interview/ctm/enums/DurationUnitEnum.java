package com.s2u2m.interview.ctm.enums;

/**
 * enum DurationUnitEnum
 *
 * @author xiayy860612
 * @date 2018/5/17
 */
public enum DurationUnitEnum {
    Lightning("lightning"),
    Min("min")
    ;

    private String name;
    DurationUnitEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
