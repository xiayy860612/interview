package com.s2u2m.interview.ctm.utils;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class IntUtilsTest {

    @Test
    public void rangeClosed__success() {
        int[] rst = IntUtils.rangeClosed(10, 20,2);
        assertEquals(6, rst.length);

        rst = IntUtils.rangeClosed(10, 19,2);
        assertEquals(6, rst.length);
    }

}