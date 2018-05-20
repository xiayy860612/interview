package com.s2u2m.interview.ctm.entity.session;

import com.s2u2m.interview.ctm.entity.base.FreeDuration;
import com.s2u2m.interview.ctm.entity.session.item.Talk;
import org.junit.Test;

import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.*;

public class SessionTest {

    @Test
    public void getDurations4Arrangable__success() {
        LocalTime start = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(12, 0);
        Session session = new Session(start, end);

        LocalTime ts = LocalTime.of(11, 0);
        LocalTime te = LocalTime.of(11, 30);
        Talk talk = new Talk("test", ts, te);
        session.addItem(talk);

        List<FreeDuration> durations = session.getFreeDurations();
        assertEquals(2, durations.size());

        // first one
        FreeDuration duration1 = durations.get(0);
        int ad1 = (ts.toSecondOfDay() - start.toSecondOfDay())/60;
        assertEquals(ad1, duration1.getDuration());

        // second one
        FreeDuration duration2 = durations.get(1);
        int ad2 = (end.toSecondOfDay() - te.toSecondOfDay())/60;
        assertEquals(ad2, duration2.getDuration());
    }

    @Test
    public void getFullDuration__success() {
        LocalTime start = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(12, 0);
        int exp = (end.toSecondOfDay() - start.toSecondOfDay())/60;

        Session session = new Session(
                start, end
        );
        assertEquals(exp, session.getDuration());
    }

    @Test
    public void getExactEnd__success() {
        Session session = new Session(LocalTime.of(9, 0), 120);
        assertEquals(session.getStart().toSecondOfDay(), session.getExactEnd().toSecondOfDay());

        Talk talk = new Talk("test", LocalTime.of(10, 10), 30);
        session.addItem(talk);
        assertEquals(talk.getEnd(), session.getExactEnd());

    }
}