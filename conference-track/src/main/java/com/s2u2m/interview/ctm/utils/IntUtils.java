package com.s2u2m.interview.ctm.utils;

import com.s2u2m.interview.ctm.exception.CmtErrorCodeEnum;
import com.s2u2m.interview.ctm.exception.ExceptionBuilder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * class IntUtils
 *
 * @author xiayy860612
 * @date 2018/5/18
 */
public class IntUtils {
    public static int[] rangeClosed(int start, int end, int step) {
        if (start > end || step <= 0 ) {
            String err = String.format("invalid param: start[%s], end[%s], step[%s]",
                    start, end, step);
            throw ExceptionBuilder.build(CmtErrorCodeEnum.InvalidParameter, err);
        }

        int elapse = end - start;
        List<Integer> rst = IntStream.iterate(start, i -> i + step)
                .limit(elapse/step + 1)
                .boxed()
                .collect(Collectors.toList());
        if (elapse % step != 0) {
            rst.add(end);
        }

        return rst.stream().mapToInt(i -> i).toArray();
    }
}
