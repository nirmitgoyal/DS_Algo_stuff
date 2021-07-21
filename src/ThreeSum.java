import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    List<Indexes> result = new ArrayList<>();

    void threeSum(int[] a, int targetSum) {
        Arrays.sort(a);

        for (int i = 0; i < n - 2; i++)
            twoSumSortedModified(a, targetSum, i); //without passing the index, we'll have to check if it was not the same index
    }

    private void twoSumSortedModified(int[] a, int targetSum, final int startIndex) {
        int
                l = startIndex+1,
                r = n - 1;

        while (l < r) {
            int sum = a[startIndex] + a[l] + a[r];

            if (sum == targetSum) {
                result.add(new Indexes(startIndex, l, r));
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
    static class Indexes {
        int i1, i2, i3;
    }
}
