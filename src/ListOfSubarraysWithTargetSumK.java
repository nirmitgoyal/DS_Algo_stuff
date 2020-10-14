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

            Integer index = map.get(sum - k);
            if (index != null)
                result.add(new Interval(index + 1, i));
        }

        return result;
    }
}
