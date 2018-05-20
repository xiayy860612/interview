package com.s2u2m.interview.ctm.entity.base;

import com.s2u2m.interview.ctm.exception.CmtErrorCodeEnum;
import com.s2u2m.interview.ctm.exception.ExceptionBuilder;
import com.s2u2m.interview.ctm.utils.time.TimeUtils;

import java.time.LocalTime;

/**
 * class AbLocalTimeSeqItem
 *
 * @author xiayy860612
 * @date 2018/5/17
 */
public abstract class AbLocalTimeSeqItem implements ILocalTimeSequence {


    /**
     * start time
     */
    private LocalTime start;

    /**
     * end time
     */
    private LocalTime end;


    /**
     * create session by duration
     *
     * @param start    start time for session
     * @param duration duration based on start time, unit is minute
     */
    protected AbLocalTimeSeqItem(LocalTime start, int duration) {
        this(start, start.plusMinutes(duration));
    }

    /**
     * create session between [start, end)
     * @param start start time for session
     * @param end end time for session
     */
    protected AbLocalTimeSeqItem(LocalTime start, LocalTime end) {
        int duration = TimeUtils.minusInMin(end, start);
        if (duration < 0) {
            throw ExceptionBuilder.build(CmtErrorCodeEnum.LocalTimeSeqItemTimeRangeError,
                    String.format("end[%s] < start[%s]", end, start));
        }

        this.start = start;
        this.end = end;
    }

    @Override
    public LocalTime getStart() {
        return start;
    }

    @Override
    public LocalTime getEnd() {
        return end;
    }
}
