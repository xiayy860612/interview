package com.s2u2m.interview.ctm.service.proposal.assigner.packageassigner.evaluator;

import com.s2u2m.interview.ctm.entity.Proposal;
import com.s2u2m.interview.ctm.service.proposal.assigner.packageassigner.AbProposalEvaluator;

/**
 * class ProposalSameValueEvaluator
 *
 * @author xiayy860612
 * @date 2018/5/18
 */
public class ProposalSameValueEvaluator extends AbProposalEvaluator {
    @Override
    public int getValue(Proposal proposal) {
        return 1;
    }
}
