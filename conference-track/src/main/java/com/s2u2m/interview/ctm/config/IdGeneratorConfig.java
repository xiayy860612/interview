package com.s2u2m.interview.ctm.config;

import com.s2u2m.interview.ctm.utils.uid.IIdGenerator;
import com.s2u2m.interview.ctm.utils.uid.SequenceUidGenerator;

/**
 * class IdGeneratorConfig
 *
 * @author xiayy860612
 * @date 2018/5/17
 */
public class IdGeneratorConfig {
    private static IIdGenerator idGenerator = new SequenceUidGenerator(0);
    public static IIdGenerator getIdGenerator() {
        return idGenerator;
    }
}
