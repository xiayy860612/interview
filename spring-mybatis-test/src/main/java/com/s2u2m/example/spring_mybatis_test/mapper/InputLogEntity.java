package com.s2u2m.example.spring_mybatis_test.mapper;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class InputLogEntity {
    private String id;
    private Date createTime;
    private String content;
}
