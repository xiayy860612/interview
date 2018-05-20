package com.s2u2m.interview.ctm.manager;

import com.s2u2m.interview.ctm.entity.track.Track;

import java.util.LinkedList;
import java.util.List;

/**
 * class CtmManager, all data content manager in content track management
 *
 * @author xiayy860612
 * @date 2018/5/17
 */
public class CtmManager {
    private static final List<Track> tracks = new LinkedList<>();

    public static void addTrack(Track track) {
        tracks.add(track);
    }

    public static final List<Track> getTracks() {
        return tracks;
    }
}
