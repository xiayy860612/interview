package com.s2u2m.interview.ctm.service.proposal.assigner;

import com.s2u2m.interview.ctm.entity.Proposal;

import java.util.List;

/**
 * interface IProposalsAssignable, get arranged list of talks
 *
 * @author xiayy860612
 * @date 2018/5/16
 */
public interface IProposalsAssignable {

    /**
     * get arranged list of proposals
     *
     * @param orig input proposals, get final proposals from it
     * @param duration sum(duration of final proposals) <= duration
     * @return arranged proposals
     */
    List<Proposal> assign(List<Proposal> orig, int duration);
}
