public class MaxProfit1Txn {

    int maxProfit1Txn(int[] a) {
        int maxProfit = 0, currentPrice = a[n - 1], maxPrice = a[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            currentPrice = a[i];
            maxPrice = Math.max(currentPrice, maxPrice);
            maxProfit = Math.max(maxPrice - currentPrice, maxProfit);
        }

        return maxProfit;
    }
}
