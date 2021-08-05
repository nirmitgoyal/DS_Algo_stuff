import java.util.Map;

public class Knapsack01Infinite {
    static int[]
            w = {1, 6, 7, 3, 8},
            v = {1, 2, 3, 4, 5};
    static int n = w.length;

    // [tested]
    int maxValue(int W) {
        if (W <= 0)
            return 0;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int weightPicked = w[i];

            if (weightPicked <= W) {
                int _1PossibleAns = maxValue(W - weightPicked) + v[i];
                ans = Math.max(ans, _1PossibleAns);
            }
        }

        return ans;
    }

    Map<Integer, Integer> cache;

    int maxValueMemo(int W) {
        if (W <= 0)
            return 0;
        if (cache.containsKey(W))
            return cache.get(W);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int weightPicked = w[i];

            if (weightPicked <= W) {
                int _1PossibleAns = maxValue(W - weightPicked) + v[i];
                ans = Math.max(ans, _1PossibleAns);
            }
        }

        cache.put(W, ans);
        return ans;
    }
}
