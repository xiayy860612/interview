package com.s2u2m.interview.ctm.utils.uid;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * class SequenceUidGenerator
 *
 * @author xiayy860612
 * @date 2018/5/17
 */
public class SequenceUidGenerator implements IIdGenerator {
    private AtomicInteger generator;

    public SequenceUidGenerator(int seed) {
        generator = new AtomicInteger(seed);
    }

    @Override
    public int nextId() {
        return generator.incrementAndGet();
    }
}
