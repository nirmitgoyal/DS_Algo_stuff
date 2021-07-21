import static java.lang.Integer.MIN_VALUE;

public class MaxSubArray {

    public int maxSubArray(int[] a) { //works for all -ve number as well
        int
                max = MIN_VALUE,
                runningSum = 0;

        for (int e : a) {
            if (runningSum < 0)
                runningSum = e;
            else
                runningSum += e;

            max = Math.max(max, runningSum);
        }

        return max;
    }
}
