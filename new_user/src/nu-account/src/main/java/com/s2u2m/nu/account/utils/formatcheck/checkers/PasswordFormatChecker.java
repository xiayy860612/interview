package com.s2u2m.nu.account.utils.formatcheck.checkers;


import com.s2u2m.nu.account.utils.formatcheck.AbFormatChecker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class PasswordFormatChecker extends AbFormatChecker<String> {

    private static Pattern pattern;

    static {
        String specialChars = "!@#$%^&*()-+=";
        String reg = String.format("^[a-zA-Z][\\w%s]+$", specialChars);
        pattern = Pattern.compile(reg);
    }

    private int minLen;
    private int maxLen;

    public PasswordFormatChecker(String data, int minLength, int maxLength) {
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
