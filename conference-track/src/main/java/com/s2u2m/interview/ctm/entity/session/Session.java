package com.s2u2m.interview.ctm.entity.session;


import com.s2u2m.interview.ctm.entity.base.AbLocalTimeSeqContainer;
import java.time.LocalTime;

/**
 * class Session
 *
 * @author xiayy860612
 * @date 2018/5/16
 */
public final class Session extends AbLocalTimeSeqContainer<AbSessionItem> {

    public Session(LocalTime start, int duration) {
        super(start, duration);
    }

    public Session(LocalTime start, LocalTime end) {
        super(start, end);
    }

}
