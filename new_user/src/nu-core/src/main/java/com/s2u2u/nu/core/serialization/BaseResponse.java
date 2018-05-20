package com.s2u2u.nu.core.serialization;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Base response.
 *
 * @author Amos Xia
 */
@Getter
@Setter
public abstract class BaseResponse {
    protected int code = 0;
}
