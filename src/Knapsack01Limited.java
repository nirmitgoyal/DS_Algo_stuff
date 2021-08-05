import java.util.Map;

public class Knapsack01Limited {
    static int[]
            w = {1, 6, 7, 3, 8},
            v = {1, 2, 3, 4, 5};

    static int n = w.length;

    int maxValue(int W) {
        return maxValueHelper(W, n);
    }

    private int maxValueHelper(int W, int size) {
        if (W <= 0 || size == 0)
            return 0;

        int
                index = size - 1,
                weightPicked = w[index],
                ans = 0;

        if (weightPicked <= W)
            ans = Math.max(
                    maxValueHelper(W - weightPicked, index) + v[index],
                    maxValueHelper(W, index)); // [same]
        else
            ans = maxValueHelper(W, index); // [same]

        return ans;
    }

    Map<String, Integer> cache;
    private int maxValueHelperMemo(int W, int size) {
        if (W <= 0 || size == 0)
            return 0;
        if (cache.containsKey(getKey(W, size)))
            return cache.get(getKey(W, size));

        int
                index = size - 1,
                weightPicked = w[index],
                ans = 0;

        if (weightPicked <= W)
            ans = Math.max(maxValueHelper(W - weightPicked, index) + v[index],
                    maxValueHelper(W, index));
        else
            ans = maxValueHelper(W, index);

        cache.put(getKey(W, size), ans);
        return ans;
    }

    private String getKey(int W, int size) {
        return W + "_" + size;
    }

}
