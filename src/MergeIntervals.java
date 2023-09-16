import MinNumberOfMeetingRooms.CustomComparator_Start;
import models.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    List<Interval> mergeIntervals(Interval[] intervals) {
        List<Interval> result = new ArrayList<>();
        Arrays.sort(intervals, new CustomComparator_Start());

        for (Interval interval : intervals) {
            int resultTailEnd = result.get(result.size() - 1).end;
            if (!result.isEmpty() &&  resultTailEnd >= interval.start)
                result.get(result.size() - 1).end = Math.max(resultTailEnd, interval.end);
            else
                result.add(interval);
        }

        return result;
    }
}
