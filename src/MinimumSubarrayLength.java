import static java.lang.Integer.MAX_VALUE;

public class MinimumSubarrayLength {

    int minimumSubarrayLength(int[] a, int k) {
        int l = 0, r = 0, sum = 0, minLength = MAX_VALUE;

        while (r < n) {
            sum += a[l];

            while (sum >= k) {
                sum -= a[l];
                l++;
                minLength = Math.min(r - l + 1, minLength);
            }

            r++;
        }

        return minLength;
    }

    int minimumSubarrayLengthBruteForce(int[] a, int k) {
        int sum, min = MAX_VALUE;

        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                if (sum >= k) {
                    min = Math.min(j - i + 1, min);
                    break;
                }
            }
        }

        return min;
    }
}
