public class MaxProfit1Txn {

    int maxProfit1Txn(int[] a) {
        int
                maxProfit = 0,
                maxSP = a[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            maxSP = Math.max(maxSP, a[i]);
            maxProfit = Math.max(maxProfit, maxSP - a[i]);
        }

        return maxProfit;
    }
}
