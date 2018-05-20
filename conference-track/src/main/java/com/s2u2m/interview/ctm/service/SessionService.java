package com.s2u2m.interview.ctm.service;

import com.s2u2m.interview.ctm.entity.Proposal;
import com.s2u2m.interview.ctm.entity.session.AbSessionItem;
import com.s2u2m.interview.ctm.entity.session.item.Talk;
import com.s2u2m.interview.ctm.entity.session.Session;
import com.s2u2m.interview.ctm.entity.base.FreeDuration;
import com.s2u2m.interview.ctm.manager.ServiceManager;
import com.s2u2m.interview.ctm.service.proposal.assigner.IProposalsAssignable;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * class SessionService
 *
 * @author xiayy860612
 * @date 2018/5/17
 */
public class SessionService {

    /**
     * Assign proposals to specific duration with no gap,
     * and ordered
     *
     * @param session proposals will be assigned to it
     * @param duration free duration for proposals assignment
     * @param orig input proposals
     * @param assigner arrange proposals in specific duration
     * @param comparator used to order arranged proposals
     * @return rest proposals not arranged
     */
    public List<Proposal> assignSequenceProposals(
            Session session, FreeDuration duration,
            List<Proposal> orig,
            IProposalsAssignable assigner,
            Comparator<Proposal> comparator) {

        // get arranged proposals and ordered
        List<Proposal> arrangedProposals = assigner.assign(orig, duration.getDuration());
        if (arrangedProposals.size() == 0) {
            return orig;
        }

        arrangedProposals.sort(comparator);

        // ordered and convert proposals to arranged talks
        List<AbSessionItem> talks = new LinkedList<>();
        LocalTime start = duration.getStart();
        for (Proposal proposal : arrangedProposals) {
            Talk talk = ServiceManager.getTalkService().convert(start, proposal);

            talks.add(talk);
            start = start.plusMinutes(proposal.getDuration());
        }

        // add arranged talks into session
        session.addItems(talks);

        // remove orig and return rest
        List<Proposal> rest = orig.stream()
                .filter(p -> !arrangedProposals.contains(p))
                .collect(Collectors.toList());
        return rest;
    }


    public void printSession(Session session) {
        for (AbSessionItem item : session.getItems()) {
            System.out.println(item);
        }
    }
}
