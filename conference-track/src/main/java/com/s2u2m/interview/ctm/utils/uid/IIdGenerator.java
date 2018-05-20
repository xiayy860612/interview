package com.s2u2m.interview.ctm.utils.uid;

/**
 * interface IIdGenerator
 *
 * @author xiayy860612
 * @date 2018/5/17
 */
public interface IIdGenerator {
    int nextId();

    default String nextIdByString() {
        int id = nextId();
        return Integer.toString(id);
    }
}
