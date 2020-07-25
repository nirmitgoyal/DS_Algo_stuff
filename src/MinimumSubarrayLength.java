import static java.lang.Integer.MAX_VALUE;

public class MinimumSubarrayLength {

    int minimumSubarrayLength(int[] a, int k) {
        int left = 0, right = 0, sum = 0, minLength = MAX_VALUE;

        while (right < n) {
            sum += a[left];

            while (sum >= k) {
                sum -= a[left];
                left++;
                minLength = Math.min(right - left + 1, minLength);
            }

            right++;
        }

        return minLength;
    }
}
