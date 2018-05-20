package com.s2u2m.interview.ctm;

import com.s2u2m.interview.ctm.entity.Proposal;
import com.s2u2m.interview.ctm.exception.CmtErrorCodeEnum;
import com.s2u2m.interview.ctm.exception.CmtException;
import com.s2u2m.interview.ctm.exception.ExceptionBuilder;
import com.s2u2m.interview.ctm.manager.CtmManager;
import com.s2u2m.interview.ctm.manager.ServiceManager;
import com.s2u2m.interview.ctm.service.proposal.assigner.IProposalsAssignable;
import com.s2u2m.interview.ctm.service.proposal.assigner.packageassigner.IProposalEvaluable;
import com.s2u2m.interview.ctm.service.proposal.assigner.packageassigner.ProposalsPackageAssigner;
import com.s2u2m.interview.ctm.service.proposal.assigner.packageassigner.evaluator.ProposalSameValueEvaluator;
import com.s2u2m.interview.ctm.service.proposal.sort.ProposalNoOrder;

import java.util.List;

/**
 * class AppMain
 *
 * @author xiayy860612
 * @date 2018/5/16
 */
public class AppMain {


    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
           System.out.println(helpInfo());
           return;
        }

        try {
            String filePath = args[0];
            start(filePath);
        } catch (CmtException cex) {
            printError(cex);
        } catch (Exception ex) {
            ex.printStackTrace();

            CmtException cex = ExceptionBuilder
                    .build(CmtErrorCodeEnum.InternalError, ex.toString());
            printError(cex);
        }
    }

    private static void printError(CmtException cex) {
        StringBuilder builder = new StringBuilder("error:");

        String err = String.format("code:%d, msg: %s", cex.getCode(), cex.getMessage());
        builder.append(err);

        System.out.println(builder.toString());
    }

    private static String helpInfo() {
        StringBuilder builder = new StringBuilder("Help: ");
        builder.append("\n");
        builder.append("\tinterview.conferencetrack-1.0-SNAPSHOT.jar <proposal_input_file_path>");
        return builder.toString();
    }

    private static void start(String inputFile) {
        // get proposal from input file
        List<Proposal> proposals = ServiceManager.getProposalReaderService().read(inputFile);

        // assign proposals to track
        IProposalEvaluable evaluator = new ProposalSameValueEvaluator();
        IProposalsAssignable assigner = new ProposalsPackageAssigner(evaluator, 1);
        ProposalNoOrder sorter = new ProposalNoOrder();
        while (proposals.size() != 0) {
            proposals = ServiceManager.getTrackService()
                    .assignSequenceProposals(proposals, assigner, sorter);
        }

        // print talks in tracks
        CtmManager.getTracks().stream().forEach(ServiceManager.getTrackService()::printTrack);
    }


}
