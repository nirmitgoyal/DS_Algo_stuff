import java.util.Arrays;

public class ThreeSumClosest {

    int threeSumClosest(int[] a, int targetSum) {
        Arrays.sort(a);
        int ans = 0;

        for (int i = 0; i < n - 2; i++)
            ans += twoSumSortedModified(a, targetSum, i);

        return ans;
    }

    private int twoSumSortedModified(int[] a, int targetSum, int startIndex) {
        int
                l = startIndex + 1,
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
