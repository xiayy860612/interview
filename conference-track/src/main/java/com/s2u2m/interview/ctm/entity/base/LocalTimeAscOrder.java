package com.s2u2m.interview.ctm.entity.base;

import com.s2u2m.interview.ctm.utils.time.TimeUtils;

import java.util.Comparator;

/**
 * class LocalTimeAscOrder
 *
 * @author xiayy860612
 * @date 2018/5/17
 */
public class LocalTimeAscOrder implements Comparator<ILocalTimeSequence> {
    @Override
    public int compare(ILocalTimeSequence o1, ILocalTimeSequence o2) {
        int rst = TimeUtils.minusInMin(o1.getStart(), o2.getStart());
        return rst;
    }
}
