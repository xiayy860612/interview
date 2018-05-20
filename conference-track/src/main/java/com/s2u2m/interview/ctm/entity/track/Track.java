package com.s2u2m.interview.ctm.entity.track;

import com.s2u2m.interview.ctm.entity.base.AbLocalTimeSeqContainer;
import com.s2u2m.interview.ctm.entity.session.Session;

import java.time.LocalTime;

/**
 * class Track
 *
 * @author xiayy860612
 * @date 2018/5/16
 */
public final class Track extends AbLocalTimeSeqContainer<Session> {

    private int id;

    public Track(int id) {
        super(LocalTime.of(0, 0), LocalTime.of(23, 59));
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Track %d", this.id);
    }
}
