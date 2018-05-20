package com.s2u2m.interview.ctm.service.proposal.assigner.packageassigner;

import com.s2u2m.interview.ctm.entity.Proposal;

/**
 * class AbProposalEvaluator
 *
 * @author xiayy860612
 * @date 2018/5/18
 */
public abstract class AbProposalEvaluator implements IProposalEvaluable {

    @Override
    public int getWeight(Proposal proposal) {
        return proposal.getDuration();
    }

}
