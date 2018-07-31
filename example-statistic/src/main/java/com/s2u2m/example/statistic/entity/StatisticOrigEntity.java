package com.s2u2m.example.statistic.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * StatisticOrigEntity
 *
 * @author Amos Xia
 * @version x.x.x, 2018/7/31
 */
@Getter
@Setter
public class StatisticOrigEntity {
    private String name;
    private Long cnt;
    private Date createTime;
}
