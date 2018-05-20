package com.s2u2m.interview.ctm.manager;

import com.s2u2m.interview.ctm.service.proposal.ProposalReaderService;
import com.s2u2m.interview.ctm.service.SessionService;
import com.s2u2m.interview.ctm.service.TalkService;
import com.s2u2m.interview.ctm.service.TrackService;

/**
 * class ServiceManager
 *
 * @author xiayy860612
 * @date 2018/5/17
 */
public class ServiceManager {
    private static final ProposalReaderService proposalReaderService = new ProposalReaderService();
    private static final TrackService trackService = new TrackService();
    private static final SessionService sessionService = new SessionService();

    public static final ProposalReaderService getProposalReaderService() {
        return proposalReaderService;
    }

    public static final TrackService getTrackService() {
        return trackService;
    }

    public static final SessionService getSessionService() {
        return sessionService;
    }

    private static final TalkService talkService = new TalkService();

    public static TalkService getTalkService() {
        return talkService;
    }
}
