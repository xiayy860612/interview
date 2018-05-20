package com.s2u2m.interview.ctm.service;

import com.s2u2m.interview.ctm.entity.Proposal;
import com.s2u2m.interview.ctm.entity.session.Session;
import com.s2u2m.interview.ctm.entity.base.FreeDuration;
import com.s2u2m.interview.ctm.entity.session.item.Talk;
import com.s2u2m.interview.ctm.manager.ServiceManager;
import com.s2u2m.interview.ctm.service.proposal.assigner.IProposalsAssignable;
import com.s2u2m.interview.ctm.service.proposal.assigner.ProposalSequenceAssigner;
import com.s2u2m.interview.ctm.service.proposal.sort.ProposalNoOrder;
import org.junit.Test;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class SessionServiceTest {

    @Test
    public void assignSequenceProposals__success() {
        // prepare
        List<Proposal> proposals = new LinkedList<>();
        proposals.add(new Proposal("test1", 60));
        proposals.add(new Proposal("test2", 30));
        proposals.add(new Proposal("test3", 40));
        proposals.add(new Proposal("test4", 70));

        Session session = new Session(
                LocalTime.of(9, 0),
                120
        );
        FreeDuration duration = session.getFreeDurations().get(0);

        // execute
        IProposalsAssignable assigner = new ProposalSequenceAssigner();
        ProposalNoOrder order = new ProposalNoOrder();
        List<Proposal> rest = ServiceManager.getSessionService().assignSequenceProposals(
                session, duration, proposals, assigner, order);

        // verify
        assertEquals(2, rest.size());

        List<Talk> items = session.getItems().stream()
                .map(item -> (Talk)item)
                .collect(Collectors.toList());
        assertEquals(2, items.size());

        boolean matched = items.stream().allMatch(item ->
                Arrays.asList("test1", "test2").contains(item.getTitle()));
        assertTrue(matched);
    }
}