import models.Interval;

import java.util.PriorityQueue;

public class MinNumberOfMeetingRooms {

    int minNumberOfMeetingRooms(Interval[] a) {
        a.sort();//with the comparator sorting by start
        PriorityQueue<Integer> endIntervals = new PriorityQueue<>();

        int max = 0;

        for (Interval interval : a) {
            while (!endIntervals.isEmpty() && endIntervals.peek() <= interval.start) {
                endIntervals.poll();
            }

            endIntervals.add(interval.end);
            max = Math.max(endIntervals.size(), max);
        }

        return max;
    }
}
