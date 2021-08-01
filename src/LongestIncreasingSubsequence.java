import java.util.Map;

public class LongestIncreasingSubsequence {
    int[] a;
    Map<Integer, Integer> cache;

    int longestIncreasingSubsequenceLength(int index) {
        //no base needed
        int ans = 1;
        for (int i = 0; i < index; i++)
            if (a[index] > a[i])
                ans = Math.max(ans, longestIncreasingSubsequenceLength(i) + 1);

        return ans;
    }

    int longestIncreasingSubsequenceLength2(int index) {
        if (cache.containsKey(index))
            return cache.get(index);

        int ans = 1;
        for (int i = 0; i < index; i++)
            if (a[index] > a[i])
                ans = Math.max(ans, longestIncreasingSubsequenceLength(i) + 1);

        cache.put(index, ans);
        return ans;
    }
}
