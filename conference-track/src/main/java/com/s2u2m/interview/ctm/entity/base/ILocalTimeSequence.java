package com.s2u2m.interview.ctm.entity.base;

import com.s2u2m.interview.ctm.utils.time.TimeUtils;

import java.time.LocalTime;

/**
 * interface ILocalTimeSequence,
 *
 * item is based on LocalTime arrangement, [start, end)
 *
 * @author xiayy860612
 * @date 2018/5/17
 */
public interface ILocalTimeSequence {

    LocalTime getStart();

    LocalTime getEnd();

    /**
     * Expected duration, duration between [start, end)
     *
     * @return
     */
    default int getDuration() {
        return TimeUtils.minusInMin(getEnd(), getStart());
    }

}
