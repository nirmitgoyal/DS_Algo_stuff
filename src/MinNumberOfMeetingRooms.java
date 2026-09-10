import static java.lang.Math.max;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import models.Interval;

public class MinNumberOfMeetingRooms {

  int minNumberOfMeetingRooms(Interval[] intervals) {
    Arrays.sort(intervals, new CustomComparator_Start());
    Queue<Interval> pq = new PriorityQueue<>(new CustomComparator_End());

    int ans = 0;

    for (Interval interval : intervals) {
      //prune the invalid intervals
      while (!pq.isEmpty() && (interval.start >= pq.peek().end)) 
        pq.poll();

      pq.add(interval);

      ans = max(ans, pq.size());
    }

    return ans;
  }

  public static class CustomComparator_Start implements Comparator<Interval> {

    public int compare(Interval e1, Interval e2) {
      return e1.start.compareTo(e2.start);
    }
  }

  public static class CustomComparator_End implements Comparator<Interval> {

    public int compare(Interval e1, Interval e2) {
      return e1.end.compareTo(e2.end);
    }
  }
}
