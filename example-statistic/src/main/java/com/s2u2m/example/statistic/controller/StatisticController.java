package com.s2u2m.example.statistic.controller;

import com.s2u2m.example.statistic.dto.StatisticDto;
import com.s2u2m.example.statistic.entity.StatisticSumEntity;
import com.s2u2m.example.statistic.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * StatisticController
 *
 * @author Amos Xia
 * @version x.x.x, 2018/7/31
 */
@RestController
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @GetMapping("/statistic/{mins}")
    public List<StatisticDto> getStatistic(@PathVariable("mins") int lastMins) {
        List<StatisticSumEntity> rst = statisticService.getSum(lastMins);
        return rst.stream().map(sumEntity -> {
            StatisticDto dto = new StatisticDto();
            dto.setName(sumEntity.getName());
            dto.setAmount(sumEntity.getAmount());
            return dto;
        }).collect(Collectors.toList());
    }
}
