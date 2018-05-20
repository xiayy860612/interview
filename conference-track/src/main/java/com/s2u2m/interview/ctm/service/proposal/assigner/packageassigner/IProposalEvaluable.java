package com.s2u2m.interview.ctm.service.proposal.assigner.packageassigner;

import com.s2u2m.interview.ctm.entity.Proposal;

/**
 * class IProposalEvaluable,
 * provide evaluation info
 *
 * @author xiayy860612
 * @date 2018/5/18
 */
public interface IProposalEvaluable {

    /**
     * determine if it could be collected
     *
     * @param proposal target proposal
     * @return weight
     */
    int getWeight(Proposal proposal);

    /**
     * determine if it will be best selection
     *
     * @param proposal target proposal
     * @return value
     */
    int getValue(Proposal proposal);
}
