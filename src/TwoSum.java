import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    List<Element> result = new ArrayList<>();

    void twoSum(int[] a, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++)
            map.put(a[i], i);

        for (int i = 0; i < a.length; i++) {
            int complement = targetSum - a[i];

            if (map.containsKey(complement) && map.get(complement) != i)
                result.add(new Element(i, map.get(complement)));
        }
    }

    void twoSumSorted(int[] a, int targetSum) {//a is sorted
        int
                l = 0,
                r = n - 1;

        while (l < r) {
            int sum = a[l] + a[r];

            if (sum == targetSum) {
                result.add(new Element(a[l], a[r]));
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
    class Element {
        int e1, e2;
    }
}
