package com.s2u2m.interview.ctm.entity.session.item;

import com.s2u2m.interview.ctm.entity.session.AbSessionItem;
import com.s2u2m.interview.ctm.utils.time.TimeUtils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * class SessionEvent
 *
 * @author xiayy860612
 * @date 2018/5/17
 */
public class SessionEvent extends AbSessionItem {

    private String title;

    public SessionEvent(String title, LocalTime start) {
        super(start, start);
        this.title = title;
    }

    @Override
    public String toString() {
        String start = this.getStart().format(TimeUtils.LocalTimeFormatter);
        String out = String.format("%s %s", start, this.title);
        return out;
    }
}
