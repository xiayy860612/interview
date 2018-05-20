package com.s2u2m.interview.ctm.service;

import com.s2u2m.interview.ctm.config.ConstantConfig;
import com.s2u2m.interview.ctm.entity.Proposal;
import com.s2u2m.interview.ctm.manager.ServiceManager;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProposalReaderServiceTest {

    @Test
    public void convertMinUnit__success() {
        String line = "Writing Fast Tests Against Enterprise Rails 60min";
        Proposal proposal = ServiceManager.getProposalReaderService().convert(line);
        assertEquals(60, proposal.getDuration());
    }

    @Test
    public void convertLightingUnit__success() {
        String line = "Rails for Python Developers lightning";
        Proposal proposal = ServiceManager.getProposalReaderService().convert(line);
        assertEquals(ConstantConfig.DurationUnitLightning, proposal.getDuration());
    }


    @Test
    public void read__success() {
        ClassLoader loader = this.getClass().getClassLoader();
        String inputFilePath = loader.getResource("proposals.txt").getPath();

        List<Proposal> proposals = ServiceManager.getProposalReaderService().read(inputFilePath);
        assertEquals(19, proposals.size());
    }
}