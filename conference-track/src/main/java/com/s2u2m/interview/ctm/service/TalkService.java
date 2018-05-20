package com.s2u2m.interview.ctm.service;

import com.s2u2m.interview.ctm.entity.Proposal;
import com.s2u2m.interview.ctm.entity.session.item.Talk;

import java.time.LocalTime;

/**
 * class TalkService
 *
 * @author xiayy860612
 * @date 2018/5/17
 */
public class TalkService {

    public Talk convert(LocalTime start, Proposal proposal) {
        Talk talk = new Talk(proposal.getTitle(), start, proposal.getDuration());
        return talk;
    }
}
