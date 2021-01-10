import models.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinNumberOfMeetingRooms {

    int minNumberOfMeetingRooms(Interval[] a) {
        Arrays.sort(a, new CustomComparator());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int max = 0;

        for (Interval interval : a) {
            //prune the invalid intervals
            while (!pq.isEmpty() && (pq.peek() <= interval.start))
                pq.poll();

            pq.add(interval.end);

            max = Math.max(pq.size(), max);
        }

        return max;
    }

    static class CustomComparator implements Comparator<Interval> {
        public int compare(Interval first, Interval second) {
            return first.start.compareTo(second.start);
        }
    }
}
