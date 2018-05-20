package com.s2u2u.nu.core.serialization;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Error response.
 *
 * @author Amos Xia
 */
@Getter
@Setter
public class ErrorResponse extends BaseResponse {
    private String errMsg = "";
}
