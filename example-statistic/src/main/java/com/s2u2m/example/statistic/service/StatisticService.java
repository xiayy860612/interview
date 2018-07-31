package com.s2u2m.example.statistic.service;

import com.s2u2m.example.statistic.dao.StatisticOrigMapper;
import com.s2u2m.example.statistic.dao.StatisticSumMapper;
import com.s2u2m.example.statistic.entity.StatisticOrigEntity;
import com.s2u2m.example.statistic.entity.StatisticSumEntity;
import com.s2u2m.example.statistic.entity.StatisticSumRcdEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * StatisticService
 *
 * @author Amos Xia
 * @version x.x.x, 2018/7/31
 */
@Service
public class StatisticService {

    @Autowired
    private StatisticSumMapper sumMapper;

    @Autowired
    private StatisticOrigMapper origMapper;

    public List<StatisticSumEntity> getSum(int mins) {
        return sumMapper.statistic(mins);
    }


}
