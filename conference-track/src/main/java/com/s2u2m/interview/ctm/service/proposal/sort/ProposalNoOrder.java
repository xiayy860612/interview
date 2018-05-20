package com.s2u2m.interview.ctm.service.proposal.sort;

import com.s2u2m.interview.ctm.entity.Proposal;

import java.util.Comparator;

/**
 * class ProposalNoOrder
 *
 * @author xiayy860612
 * @date 2018/5/17
 */
public class ProposalNoOrder implements Comparator<Proposal> {
    @Override
    public int compare(Proposal o1, Proposal o2) {
        return 1;
    }
}
