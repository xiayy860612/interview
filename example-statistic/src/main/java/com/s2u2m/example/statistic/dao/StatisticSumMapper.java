package com.s2u2m.example.statistic.dao;

import com.s2u2m.example.statistic.entity.StatisticSumEntity;
import com.s2u2m.example.statistic.entity.StatisticSumRcdEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * StatisticSumMapper
 *
 * @author Amos Xia
 * @version x.x.x, 2018/7/31
 */
public interface StatisticSumMapper {

    void collectLastMinRcds();

    List<StatisticSumEntity> statistic(@Param("lastMins") Integer lastMins);
}
