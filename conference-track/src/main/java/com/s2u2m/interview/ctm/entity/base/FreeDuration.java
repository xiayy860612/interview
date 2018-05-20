package com.s2u2m.interview.ctm.entity.base;

import java.time.LocalTime;

/**
 * class FreeDuration, free duration could be used to arrange item in it
 *
 * @author xiayy860612
 * @date 2018/5/17
 */
public class FreeDuration extends AbLocalTimeSeqItem {

    public FreeDuration(LocalTime start, int duration) {
        super(start, duration);
    }

    public FreeDuration(LocalTime start, LocalTime end) {
        super(start, end);
    }
}
