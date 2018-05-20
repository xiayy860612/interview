package com.s2u2m.interview.ctm.entity.base;

import com.s2u2m.interview.ctm.utils.time.TimeUtils;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

/**
 * interface ILocalTimeSequence,
 *
 * item is based on LocalTime arrangement, [start, end)
 *
 * @author xiayy860612
 * @date 2018/5/17
 */
public interface ILocalTimeSeqContainer<IT extends ILocalTimeSequence> extends ILocalTimeSequence {

    /**
     * Get all items in contains
     *
     * @return
     */
    List<IT> getItems();

    /**
     * append item
     *
     * @param item
     */
    void addItem(IT item);

    /**
     * add items
     *
     * @param items
     */
    void addItems(List<IT> items);

    /**
     * when all related items end, container is end.
     * if no items, container's exact end is start
     *
     * expected start <= exact end <= expected end
     *
     * @return exact end
     */
    default LocalTime getExactEnd() {
        int cnt = this.getItems().size();
        if (cnt == 0) {
            return this.getStart();
        }

        // get last item and get its end
        IT lastItem = this.getItems().get(cnt-1);
        return lastItem.getEnd();
    }

    /**
     * Get all free durations between items in container
     *
     * @return arrangable duration
     */
    default List<FreeDuration> getFreeDurations() {
        List<FreeDuration> durations = new LinkedList<>();

        int elapse = 0;
        LocalTime preEnd = this.getStart();
        for (IT talk: this.getItems()) {
            elapse = TimeUtils.minusInMin(talk.getStart(), preEnd);
            if (elapse > 0) {
                // exists some free duration
                FreeDuration duration =
                        new FreeDuration(preEnd, elapse);
                durations.add(duration);
            }

            preEnd = talk.getEnd();
        }

        elapse = TimeUtils.minusInMin(this.getEnd(), preEnd);
        if (elapse > 0) {
            FreeDuration duration =
                    new FreeDuration(preEnd, elapse);
            durations.add(duration);
        }

        return durations;
    }

}
