import java.util.Arrays;

public class ThreeSumClosest {

    int threeSumClosest(int[] a, int targetSum) {
        Arrays.sort(a);
        int count = 0;

        for (int i = 0; i < n; i++)
            count += twoSumSortedModified(a, targetSum, i + 1);

        return count;
    }

    private int twoSumSortedModified(int[] a, int targetSum, int startIndex) {
        int
                l = startIndex,
                r = n - 1,
                count = 0;

        while (l < r) {
            int sum = a[startIndex] + a[l] + a[r];

            if (sum < targetSum) { //
                count += r - l; //
                l++;
            } else {
                r--;
            }
        }

        return count;
    }
}
