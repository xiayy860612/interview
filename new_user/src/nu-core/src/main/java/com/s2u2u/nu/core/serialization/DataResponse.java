package com.s2u2u.nu.core.serialization;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * The type DataResponse.
 *
 * @param <T>  the type parameter
 */
@Getter
@Setter
@Accessors(chain = true)
public class DataResponse<T> extends BaseResponse {
    private T data;
}
