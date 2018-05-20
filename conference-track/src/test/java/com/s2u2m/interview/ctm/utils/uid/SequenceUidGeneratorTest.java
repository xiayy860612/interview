package com.s2u2m.interview.ctm.utils.uid;

import org.junit.Test;

import static org.junit.Assert.*;

public class SequenceUidGeneratorTest {

    @Test
    public void next__success() {
        SequenceUidGenerator generator = new SequenceUidGenerator(0);
        assertEquals(1, generator.nextId());
        assertEquals(2, generator.nextId());
    }
}