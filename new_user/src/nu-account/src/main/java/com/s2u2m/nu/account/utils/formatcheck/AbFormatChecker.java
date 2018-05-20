package com.s2u2m.nu.account.utils.formatcheck;

/**
 * @author Amos Xia
 * @date 2018/4/9
 */
public abstract class AbFormatChecker<DT> implements IFormatChecker {
    protected DT data;
    protected AbFormatChecker(DT data) {
        this.data = data;
    }
}
