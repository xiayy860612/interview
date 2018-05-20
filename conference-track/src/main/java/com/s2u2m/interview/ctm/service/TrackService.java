package com.s2u2m.interview.ctm.service;

import com.s2u2m.interview.ctm.config.IdGeneratorConfig;
import com.s2u2m.interview.ctm.entity.Proposal;
import com.s2u2m.interview.ctm.entity.session.AbSessionItem;
import com.s2u2m.interview.ctm.entity.session.Session;
import com.s2u2m.interview.ctm.entity.track.Track;
import com.s2u2m.interview.ctm.entity.base.FreeDuration;
import com.s2u2m.interview.ctm.entity.session.item.SessionEvent;
import com.s2u2m.interview.ctm.manager.CtmManager;
import com.s2u2m.interview.ctm.manager.ServiceManager;
import com.s2u2m.interview.ctm.service.proposal.assigner.IProposalsAssignable;
import com.s2u2m.interview.ctm.utils.time.TimeUtils;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * class TrackService
 *
 * @author xiayy860612
 * @date 2018/5/16
 */
public class TrackService {

    /**
     * create new track and assign proposals to it
     *
     * @param orig input proposals
     * @return rest proposals not arranged
     */
    public List<Proposal> assignSequenceProposals(
            List<Proposal> orig,
            IProposalsAssignable assigner,
            Comparator<Proposal> sorter) {
        if (orig == null || orig.size() == 0) {
            return orig;
        }

        int id = IdGeneratorConfig.getIdGenerator().nextId();
        Track track = new Track(id);

        // create session and add to track
        Session morning = new Session(
                LocalTime.of(9, 0),
                LocalTime.of(12, 0)
        );
        track.addItem(morning);

        Session lunch = new Session(
                LocalTime.of(12, 0),
                LocalTime.of(13, 0)
        );
        AbSessionItem lunchEvt = new SessionEvent("Lunch", lunch.getStart());
        lunch.addItem(lunchEvt);
        track.addItem(lunch);

        Session afternoon = new Session(
                LocalTime.of(13, 0),
                LocalTime.of(17, 0)
        );
        track.addItem(afternoon);

        // assign proposals to morning session
        List<Proposal> rest = orig;
        // morning
        FreeDuration freeDuration = new FreeDuration(
                morning.getStart(), morning.getDuration());
        rest = ServiceManager.getSessionService().assignSequenceProposals(
                    morning, freeDuration, rest, assigner, sorter);

        // afternoon
        freeDuration = new FreeDuration(
                afternoon.getStart(), afternoon.getDuration());
        rest = ServiceManager.getSessionService().assignSequenceProposals(
                afternoon, freeDuration, rest, assigner, sorter);

        // add network event for after session
        LocalTime netEvtExpStart = LocalTime.of(16, 0);
        LocalTime netEvtStart = afternoon.getExactEnd();
        int rst = TimeUtils.minusInMin(netEvtStart, netEvtExpStart);
        if (rst < 0) {
            netEvtStart = netEvtExpStart;
        }
        SessionEvent netEvt = new SessionEvent("Networking Event", netEvtStart);
        afternoon.addItem(netEvt);

        // add into conference track manager
        CtmManager.addTrack(track);
        return rest;
    }

//    /**
//     * Search from start point in track,
//     * look forward for enough duration, then create session in it.
//     *
//     * new created session will no gap with nearby session.
//     *
//     * @param track
//     * @param start
//     * @return
//     */
//    public Session lookForNoGapSession(Track track, LocalTime start, int duration) {
//        track.getFreeDurations().stream()
//                .filter(freeDuration -> {
//                    int rst = TimeUtils.minusInMin(start, freeDuration.getEnd());
//                    if (rst >= 0) {
//                        // expected session after this free duration
//                        return false;
//                    }
//
//                    // free duration after start point
//                    rst = TimeUtils.minusInMin(freeDuration.getStart(), start);
//                    if (rst >= 0) {
//                        // start point before/at start of free duration
//                        if ()
//                    }
//
//                    // check if enough duration
//                    if (freeDuration.getDuration() < duration) {
//                        return false;
//                    }
//
//                    rst = TimeUtils.minusInMin(freeDuration.getEnd(), start);
//                    if (rst < duration) {
//                        return false;
//                    }
//
//                    // create session
//                    LocalTime sessionStart =
//                })
//    }

    public void printTrack(Track track) {
        System.out.println();
        String trackInfo = String.format("%s:", track);
        System.out.println(trackInfo);

        for (Session session: track.getItems()) {
            ServiceManager.getSessionService().printSession(session);
        }
    }

}
