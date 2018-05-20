package com.s2u2m.interview.ctm.entity;

/**
 * class Proposal
 *
 * @author xiayy860612
 * @date 2018/5/16
 */
public class Proposal {
    private String title;

    /**
     * unit is minute
     */
    private int duration;

    public Proposal(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return this.title;
    }

    public int getDuration() {
        return this.duration;
    }
}
