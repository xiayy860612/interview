package com.s2u2m.interview.ctm.service.proposal.assigner.packageassigner;

import com.s2u2m.interview.ctm.entity.Proposal;
import com.s2u2m.interview.ctm.exception.CmtErrorCodeEnum;
import com.s2u2m.interview.ctm.exception.ExceptionBuilder;
import com.s2u2m.interview.ctm.service.proposal.assigner.IProposalsAssignable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * class ProposalsPackageAssigner
 *
 * @author xiayy860612
 * @date 2018/5/17
 */
public class ProposalsPackageAssigner implements IProposalsAssignable {

    private IProposalEvaluable evaluator;
    private int step = 1;

    public ProposalsPackageAssigner(IProposalEvaluable evaluator, int step) {
        this.evaluator = evaluator;
        this.step = step;
    }

    /**
     * Store best result for item combination in package
     */
    private class PackageEvaluation implements Cloneable {
        /**
         * collected items for current best evaluation
         */
        private List<Proposal> proposals = new LinkedList<>();

        /**
         * evaluator from package assigner
         */
        private IProposalEvaluable evaluator;

        public PackageEvaluation(IProposalEvaluable evaluator) {
            this.evaluator = evaluator;
        }

        /**
         * used for clone
         *
         * @param src will be cloned, all fields will be copied
         */
        private PackageEvaluation(PackageEvaluation src) {
            this(src.evaluator);
            src.proposals.stream()
                    .forEach(proposal -> this.proposals.add(proposal));
        }

        public void add(Proposal proposal) {
            proposals.add(proposal);
        }

        public List<Proposal> getProposals() {
            return proposals;
        }

        public int getValue() {
            int totalValue = this.proposals.stream()
                    .mapToInt(proposal -> this.evaluator.getValue(proposal))
                    .sum();
            return totalValue;
        }

        @Override
        public PackageEvaluation clone() {
            return new PackageEvaluation(this);
        }
    }

    @Override
    public List<Proposal> assign(List<Proposal> orig, int maxWeight) {
        if (maxWeight < 0) {
            throw ExceptionBuilder.build(CmtErrorCodeEnum.InvalidParameter,
                    String.format("invalid parameters: maxWeight[%s]", maxWeight));
        }

        if (orig.size() == 0) {
            return orig;
        }

        // create table with proposal as row and maxWeight as column
        // and get row items and column items
        ArrayList<Proposal> rowItems = new ArrayList<>(orig);
        ProposalPackageWeightStepper stepper =
                new ProposalPackageWeightStepper(this.step, maxWeight);
        // TODO: current assume step is 1, improvement
//        int[] colItems = IntStream.rangeClosed(0, maxWeight).toArray();

        // cal table
        PackageEvaluation[][] rst = this.calTable(rowItems, stepper);

        // get final result
        int rowCnt = rowItems.size();
        int colCnt = stepper.getAmount();
        PackageEvaluation evl = rst[rowCnt-1][colCnt-1];
        return evl.getProposals();
    }

    private PackageEvaluation[][] calTable(
            ArrayList<Proposal> rowItems, ProposalPackageWeightStepper stepper) {

        int rowCnt = rowItems.size();
        int colCnt = stepper.getAmount();
        PackageEvaluation[][] rst = new PackageEvaluation[rowCnt][colCnt];

        // column by column
        for (int colIndex = 0; colIndex < colCnt; ++colIndex) {
            int weightAmount = stepper.get(colIndex);

            // row by row
            for (int rowIndex = 0; rowIndex < rowCnt; ++rowIndex) {
                Proposal proposal = rowItems.get(rowIndex);

                int weight = this.evaluator.getWeight(proposal);
                PackageEvaluation evaluation = new PackageEvaluation(this.evaluator);
                if (weight > weightAmount) {
                    // not enough weightAmount to collect

                    // if row index is 0, no previous best evaluation
                    // or get previous best evaluation
                    if (rowIndex != 0) {
                        evaluation = rst[rowIndex-1][colIndex];
                    }
                }
                else {
                    // enough weightAmount to collect
                    if (rowIndex == 0) {
                        // if row index is 0, no previous best evaluation
                        evaluation.add(proposal);
                    }
                    else {
                        // compare with previous best evaluation, get max one
                        // value of current item combined
                        int preExpWeight = weightAmount - weight;
                        int preColIndex = stepper.getIndex(preExpWeight);

                        PackageEvaluation preEvl = rst[rowIndex-1][preColIndex];
                        PackageEvaluation colEvl = preEvl.clone();
                        colEvl.add(proposal);
                        int colEvlValue = colEvl.getValue();

                        // previous best evaluation
                        PackageEvaluation noColEvl = rst[rowIndex-1][colIndex];
                        int noColEvlValue = noColEvl.getValue();

                        // get max value one
                        evaluation = colEvlValue >= noColEvlValue ? colEvl : noColEvl;
                    }
                }

                rst[rowIndex][colIndex] = evaluation;
            }
        }
        return rst;
    }
}
