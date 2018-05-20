package com.s2u2m.interview.ctm.entity.session;

import com.s2u2m.interview.ctm.entity.base.AbLocalTimeSeqItem;

import java.time.LocalTime;

/**
 * class AbSessionItem, represent item in session
 *
 * all items in session should inherit from AbSessionItem
 *
 * @author xiayy860612
 * @date 2018/5/17
 */
public abstract class AbSessionItem extends AbLocalTimeSeqItem {

    protected AbSessionItem(LocalTime start, LocalTime end) {
        super(start, end);
    }
}
