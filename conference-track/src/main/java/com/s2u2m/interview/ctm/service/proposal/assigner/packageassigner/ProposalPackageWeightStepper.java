package com.s2u2m.interview.ctm.service.proposal.assigner.packageassigner;

import com.s2u2m.interview.ctm.utils.IntUtils;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * class ProposalPackageWeightStepper,
 *
 * when it generated, its readonly
 *
 * @author xiayy860612
 * @date 2018/5/18
 */
public final class ProposalPackageWeightStepper {
    private int step;

    /**
     * weights stored by asc
     */
    private int[] weights;

    public ProposalPackageWeightStepper(int step, int maxWeight) {
        this.step = step;
        this.weights = IntUtils.rangeClosed(0, maxWeight, step);
    }

    public int getAmount() {
        return weights.length;
    }

    public int get(int index) {
        return weights[index];
    }

    /**
     * if weight exists in weights, return its index,
     * or return last index its weight < input weight
     * @param weight
     * @return
     */
    public int getIndex(int weight) {

        int preIndex = 0;
        for (int i = 0; i < weights.length; ++i) {
            int existedWeight = weights[i];
            if (existedWeight == weight) {
                return i;
            }

            if (existedWeight > weight) {
                break;
            }

            // existedWeight < weight
            preIndex = i;
        }

        return preIndex;
    }

}
