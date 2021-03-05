import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    List<Indexes> result = new ArrayList<>();

    void twoSum(int[] a, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            int valueToFind = targetSum - a[i];

            if (map.containsKey(valueToFind))
                result.add(new Indexes(i, map.get(valueToFind)));

            map.put(a[i], i);
        }
    }

    void twoSumSorted(int[] a, int targetSum) {//a is sorted
        int
                l = 0,
                r = n - 1;

        while (l < r) {
            int sum = a[l] + a[r];

            if (sum == targetSum) {
                result.add(new Indexes(l, r));
                l++;
                r--;
            } else if (sum < targetSum) {
                l++;
            } else {
                r--;
            }
        }
    }

    @AllArgsConstructor
    class Indexes {
        int i1, i2;
    }
}
