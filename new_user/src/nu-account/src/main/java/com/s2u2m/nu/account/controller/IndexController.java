package com.s2u2m.nu.account.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * class IndexController
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
@RestController
@RequestMapping(value = "/")
public class IndexController {

    @GetMapping(value = "/")
    public String index() {
        return "hello world";
    }
}
