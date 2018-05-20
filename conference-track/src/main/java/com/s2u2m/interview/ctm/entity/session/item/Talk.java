package com.s2u2m.interview.ctm.entity.session.item;

import com.s2u2m.interview.ctm.config.ConstantConfig;
import com.s2u2m.interview.ctm.entity.session.AbSessionItem;
import com.s2u2m.interview.ctm.enums.DurationUnitEnum;
import com.s2u2m.interview.ctm.utils.time.TimeUtils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * class Talk
 *
 * @author xiayy860612
 * @date 2018/5/16
 */
public class Talk extends AbSessionItem {

    private String title;

    public Talk(String title, LocalTime start, int duration) {
        this(title, start, start.plusMinutes(duration));
    }

    public Talk(String tile, LocalTime start, LocalTime end) {
        super(start, end);
        this.title = tile;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        int duration = getDuration();
        String durationStr = "";
        if (duration == ConstantConfig.DurationUnitLightning) {
            durationStr = DurationUnitEnum.Lightning.getName();
        } else {
            durationStr = String.format("%d%s", duration, DurationUnitEnum.Min.getName());
        }

//        if (duration % 5 == 0) {
//            duration = duration/5;
//            unitEnum = DurationUnitEnum.Lightning;
//        }

        String start = this.getStart().format(TimeUtils.LocalTimeFormatter);
        String out = String.format("%s %s %s",
                start, this.title, durationStr);
        return out;
    }

}
