import models.Interval;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListOfSubarraysWithTargetSumK {

    List<Interval> listOfSubarraysWithTargetSumK(int[] a, int targetSum) {
        List<Interval> result = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>(); //prefixSum -> index
        map.put(0, -1); // sum 0 found till index: -1

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];

            int sumToFind = sum - targetSum;
            if (map.containsKey(sumToFind))
                result.add(new Interval((map.get(sumToFind) + 1), i));

            map.put(sum, i);
        }

        return result;
    }
}
