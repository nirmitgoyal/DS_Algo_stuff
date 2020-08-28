public class LongestIncreasingSubsequence {

    int lengthOfLongestIncreasingSubsequence(int[] a) {
        int[] cache = new int[n];

        //fill cache with 1

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    cache[i] = Math.max(cache[i] + 1, cache[i]);
                }
            }
        }

        //return the max value in cache
    }
}
