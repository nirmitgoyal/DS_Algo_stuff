import static java.lang.Integer.MAX_VALUE;
import static java.lang.Math.min;

public class MinimumSubarrayLength {

  int minimumSubarrayLength(int[] a, int targetSum) {
    int
        n = a.length,
        l = 0,
        sum = 0,
        ans = MAX_VALUE;

    for (int i = 0; i < n; i++) {
      sum += a[i];

      while (sum >= targetSum) {
        ans = min(ans, i - l + 1);

        sum -= a[l];
        l++;
      }
    }

    return ans;
  }

  int minimumSubarrayLengthBruteForce(int[] a, int k) {
    int sum, min = MAX_VALUE;

    for (int i = 0; i < n; i++) {
      sum = 0;
      for (int j = i; j < n; j++) {
        sum += a[j];
        if (sum >= k) {
          min = min(j - i + 1, min);
          break;
        }
      }
    }

    return min;
  }
}
