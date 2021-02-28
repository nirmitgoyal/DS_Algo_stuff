public class Knapsack01Limited {
    int[] w, v;

    int maxValue(int W) {
        return maxValueHelper(W, w.length);
    }

    private int maxValueHelper(int W, int size) {
        if (W == 0 || size == 0)
            return 0;

        int index = size - 1;
        int weightPicked = w[index];
        if (weightPicked <= W)
            return Math.max(maxValueHelper(W - weightPicked, index) + v[index],
                    maxValueHelper(W, index));
        else
            return maxValueHelper(W, index);
    }

    Integer[][] t = new Integer[10001][10001];//n+1, W+1

    private int maxValueHelperMemo(int W, int size) {
        if (W == 0 || size == 0)
            return 0;
        if (t[size][W] != null)
            return t[size][W];

        int index = size - 1;
        int weightPicked = w[index];
        if (weightPicked <= W)
            return t[size][W] = Math.max(maxValueHelper(W - weightPicked, index) + v[index],
                    maxValueHelper(W, index));
        else
            return t[size][W] = maxValueHelper(W, index);
    }

}
