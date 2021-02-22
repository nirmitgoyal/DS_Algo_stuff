import MinNumberOfMeetingRooms.CustomComparator_Start;
import models.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    List<Interval> mergeIntervals(Interval[] intervals) {
        List<Interval> result = new ArrayList<>();
        Arrays.sort(intervals, new CustomComparator_Start());

        for (Interval interval : intervals)
            if (!result.isEmpty() && result.get(result.size() - 1).end >= interval.start)
                result.get(result.size() - 1).end = Math.max(result.get(result.size() - 1).end, interval.end);
            else
                result.add(interval);

        return result;
    }
}
