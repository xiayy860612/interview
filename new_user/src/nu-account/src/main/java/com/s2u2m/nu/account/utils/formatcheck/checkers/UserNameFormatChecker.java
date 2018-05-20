package com.s2u2m.nu.account.utils.formatcheck.checkers;

import com.s2u2m.nu.account.utils.formatcheck.AbFormatChecker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * class UserNameFormatChecker
 *
 * @author xiayy860612
 * @date 2018/5/7
 */
public final class UserNameFormatChecker extends AbFormatChecker<String> {
    private static Pattern pattern;

    static {
//        String specialChars = "!@#$%^&*()-+=";
        String reg = "^[a-zA-Z]\\w+$";
        pattern = Pattern.compile(reg);
    }


    private int minLen;
    private int maxLen;

    public UserNameFormatChecker(String data, int minLength, int maxLength) {
        super(data);

        this.minLen = minLength;
        this.maxLen = maxLength;
    }

    @Override
    public boolean check() {
        if (data.length() < minLen
                || data.length() > maxLen) {
            return false;
        }

        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }
}
