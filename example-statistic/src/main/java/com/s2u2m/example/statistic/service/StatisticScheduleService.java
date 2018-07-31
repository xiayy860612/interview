package com.s2u2m.example.statistic.service;

import com.s2u2m.example.statistic.dao.StatisticOrigMapper;
import com.s2u2m.example.statistic.dao.StatisticSumMapper;
import com.s2u2m.example.statistic.entity.StatisticOrigEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * StatisticScheduleService
 *
 * @author Amos Xia
 * @version x.x.x, 2018/7/31
 */
@Service
public class StatisticScheduleService {

    @Autowired
    private StatisticSumMapper sumMapper;

    @Autowired
    private StatisticOrigMapper origMapper;

    private List<String> names = new ArrayList<>();
    private Random random = new Random();

    @PostConstruct
    void prepare() {
        names.add("xyy");
        names.add("wj");
        names.add("xmx");
    }

    @Scheduled(fixedRate = 3000)
    public void createOrigData() {
        Long value = Long.parseLong(Integer.toString(Math.abs(random.nextInt())));
        int index = random.nextInt(names.size());
        String name = names.get(index);

        StatisticOrigEntity origEntity = new StatisticOrigEntity();
        origEntity.setName(name);
        origEntity.setCnt(value);

        origMapper.add(origEntity);
    }

    @Scheduled(fixedRate = 60000)
    public void createSumRcd() {
        sumMapper.collectLastMinRcds();
    }
}
