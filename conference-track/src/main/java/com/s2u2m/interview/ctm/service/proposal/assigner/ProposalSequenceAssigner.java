package com.s2u2m.interview.ctm.service.proposal.assigner;

import com.s2u2m.interview.ctm.entity.Proposal;

import java.util.LinkedList;
import java.util.List;

/**
 * class ProposalSequenceAssigner
 *
 * @author xiayy860612
 * @date 2018/5/17
 */
public class ProposalSequenceAssigner implements IProposalsAssignable {

    @Override
    public List<Proposal> assign(List<Proposal> orig, int duration) {
        List<Proposal> rst = new LinkedList<>();
        int restDuration = duration;
        for (Proposal proposal : orig) {
            restDuration -= proposal.getDuration();
            if (restDuration < 0) {
                break;
            }
            rst.add(proposal);
        }
        return rst;
    }
}
