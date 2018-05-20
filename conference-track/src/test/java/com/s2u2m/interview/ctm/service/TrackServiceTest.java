package com.s2u2m.interview.ctm.service;

import com.s2u2m.interview.ctm.entity.Proposal;
import com.s2u2m.interview.ctm.entity.track.Track;
import com.s2u2m.interview.ctm.manager.CtmManager;
import com.s2u2m.interview.ctm.manager.ServiceManager;
import com.s2u2m.interview.ctm.service.proposal.assigner.IProposalsAssignable;
import com.s2u2m.interview.ctm.service.proposal.assigner.ProposalSequenceAssigner;
import com.s2u2m.interview.ctm.service.proposal.sort.ProposalNoOrder;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class TrackServiceTest {

    @Test
    public void assignSequenceProposals__success() {
        // prepare
        List<Proposal> proposals = new LinkedList<>();
        int duration = 60;
        int cnt = 13;
        for(int i = 0; i < cnt; ++i) {
            String title = String.format("title %s", i);
            proposals.add(new Proposal(title, duration));
        }

        IProposalsAssignable assigner = new ProposalSequenceAssigner();
        ProposalNoOrder order = new ProposalNoOrder();
        List<Proposal> rst = ServiceManager.getTrackService()
                .assignSequenceProposals(proposals, assigner, order);

        int restCnt = cnt - 7;
        assertEquals(restCnt, rst.size());
    }
}