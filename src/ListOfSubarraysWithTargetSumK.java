import models.Interval;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListOfSubarraysWithTargetSumK {

    List<Interval> listOfSubarraysWithTargetSumK(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        List<Interval> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            sum += a[i];
            map.put(sum, i);
            if (map.containsKey(sum - k)) {
                result.add(new Interval(map.get(sum - k) + 1, i));
            }
        }

        return result;
    }
}
