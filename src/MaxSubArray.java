import static java.lang.Integer.MIN_VALUE;

public class MaxSubArray {

    public int maxSubArray(int[] a) { //works for all -ve number as well
        int
                max = MIN_VALUE,
                prefixSum = 0;

        for (int e : a) {
            if (prefixSum < 0)
                prefixSum = e;
            else
                prefixSum += e;

            max = Math.max(max, prefixSum);
        }

        return max;
    }
}
