package com.s2u2m.interview.ctm.service.proposal.assigner;

import com.s2u2m.interview.ctm.entity.Proposal;
import com.s2u2m.interview.ctm.service.proposal.assigner.packageassigner.IProposalEvaluable;
import com.s2u2m.interview.ctm.service.proposal.assigner.packageassigner.ProposalsPackageAssigner;
import com.s2u2m.interview.ctm.service.proposal.assigner.packageassigner.evaluator.ProposalSameValueEvaluator;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ProposalsPackageAssignerTest {

    /**
     * Item	weight	value	0	1	    2	    3	    4	    5	    6	    7	    8
     * 1	6	    1	    0	0	    0	    0	    0	    0	    (6)	    (6)	    (6)
     * 2	3	    1	    0	0	    0	    (2)	    (2)	    (2)	    (2)	    (2)	    (2)
     * 3	4	    1	    0	0	    0	    (2)	    (3)	    (3)	    (3)	    (2,3)	(2,3)
     * 4	7	    1	    0	0	    0	    (2)	    (3)	    (3)	    (3)	    (2,3)	(2,3)
     * 5	1	    1	    0	(5)	    (5)	    (5)	    (2,5)	(3,5)	(3,5)	(3,5)	(2,3,5)
     */
    @Test
    public void assign__success() {
        List<Proposal> proposals = new LinkedList<>();
        Proposal p1 = new Proposal("test1", 6);
        proposals.add(p1);
        Proposal p2 = new Proposal("test2", 3);
        proposals.add(p2);
        Proposal p3 = new Proposal("test3", 4);
        proposals.add(p3);
        Proposal p4 = new Proposal("test4", 7);
        proposals.add(p4);
        Proposal p5 = new Proposal("test5", 1);
        proposals.add(p5);

        int duration = 8;

        IProposalEvaluable evaluator = new ProposalSameValueEvaluator();
        ProposalsPackageAssigner assigner = new ProposalsPackageAssigner(evaluator, 1);
        List<Proposal> rst = assigner.assign(proposals, duration);

        List<Proposal> exp = new LinkedList<>();
        exp.add(p2);
        exp.add(p3);
        exp.add(p5);

        assertEquals(exp.size(), rst.size());
        boolean existed = exp.containsAll(rst);
        assertTrue(existed);
    }

    @Test
    public void assignByStep2__success() {
        List<Proposal> proposals = new LinkedList<>();
        Proposal p1 = new Proposal("test1", 6);
        proposals.add(p1);
        Proposal p2 = new Proposal("test2", 3);
        proposals.add(p2);
        Proposal p3 = new Proposal("test3", 4);
        proposals.add(p3);
        Proposal p4 = new Proposal("test4", 7);
        proposals.add(p4);
        Proposal p5 = new Proposal("test5", 1);
        proposals.add(p5);

        int duration = 8;

        IProposalEvaluable evaluator = new ProposalSameValueEvaluator();
        ProposalsPackageAssigner assigner = new ProposalsPackageAssigner(evaluator, 2);
        List<Proposal> rst = assigner.assign(proposals, duration);

        List<Proposal> exp = new LinkedList<>();
        exp.add(p3);
        exp.add(p5);

        assertEquals(exp.size(), rst.size());
        boolean existed = exp.containsAll(rst);
        assertTrue(existed);
    }
}