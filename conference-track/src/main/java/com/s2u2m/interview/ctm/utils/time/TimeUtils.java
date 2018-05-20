package com.s2u2m.interview.ctm.utils.time;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * class TimeUtils
 *
 * @author xiayy860612
 * @date 2018/5/17
 */
public class TimeUtils {

    public static int minusInMin(LocalTime end, LocalTime start) {
        return minusInSec(end, start)/60;
    }

    public static int minusInSec(LocalTime end, LocalTime start) {
        int es = end.toSecondOfDay();
        int ss = start.toSecondOfDay();
        return es - ss;
    }

    public static final DateTimeFormatter LocalTimeFormatter =
            DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
}
