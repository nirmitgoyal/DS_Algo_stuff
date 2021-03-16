public class MaxProfitWithKTxns {

    int maxProfitWithKTxns(int[] a, int k) {
        int[][] profits = new int[k + 1][n];

        //Fill 1st row and 1st column with 0

        for (int t = 1; t < k + 1; t++) {
            int maxTillNow = Integer.MIN_VALUE;
            for (int d = 1; d < n; d++) {
                maxTillNow = Math.max(maxTillNow, -a[d - 1] + profits[t - 1][d - 1]);
                profits[t][d] = Math.max(profits[t][d - 1], a[d] + maxTillNow);
            }
        }

        return profits[k][n - 1];
    }
}
