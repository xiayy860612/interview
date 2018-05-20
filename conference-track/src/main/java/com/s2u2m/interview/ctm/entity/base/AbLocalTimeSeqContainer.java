package com.s2u2m.interview.ctm.entity.base;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

/**
 * class AbLocalTimeSeqContainer
 *
 * @author xiayy860612
 * @date 2018/5/17
 */
public abstract class AbLocalTimeSeqContainer<IT extends ILocalTimeSequence>
        extends AbLocalTimeSeqItem
        implements ILocalTimeSeqContainer<IT> {

    private final List<IT> items = new LinkedList<>();
    private final LocalTimeAscOrder order = new LocalTimeAscOrder();

    protected AbLocalTimeSeqContainer(LocalTime start, int duration) {
        super(start, duration);
    }

    protected AbLocalTimeSeqContainer(LocalTime start, LocalTime end) {
        super(start, end);
    }

    @Override
    public final List<IT> getItems() {
        return this.items;
    }

    @Override
    public void addItem(IT item) {
        this.items.add(item);
        this.items.sort(this.order);
    }

    @Override
    public void addItems(List<IT> items) {
        this.items.addAll(items);
        this.items.sort(this.order);
    }



}
