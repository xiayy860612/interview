package com.s2u2m.interview.ctm.enums;

import com.s2u2m.interview.ctm.exception.CmtErrorCodeEnum;
import com.s2u2m.interview.ctm.exception.ExceptionBuilder;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * class DurationUnitHandler
 *
 * @author xiayy860612
 * @date 2018/5/17
 */
public class DurationUnitHandler {

    public static DurationUnitEnum convert(String unit) {
        Optional<DurationUnitEnum> optional =
                Stream.of(DurationUnitEnum.class.getEnumConstants())
                        .filter(et -> et.getName().equals(unit))
                        .findAny();

        if (!optional.isPresent()) {
            throw ExceptionBuilder.build(CmtErrorCodeEnum.ProposalUnitNotInvalid,
                    String.format("unit[%s] not existed", unit));
        }

        return optional.get();
    }

}
